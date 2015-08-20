package com.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the MEDIO database table.
 * 
 */
@XmlRootElement
@Entity
@Table(name = "MEDIO")
@NamedQueries({
	@NamedQuery(name="MedioEntity.findAll", query="SELECT m FROM MedioEntity m"),
	@NamedQuery(name="MedioEntity.findByEstado", query="SELECT m FROM MedioEntity m WHERE m.estado = :estado")
})
public class MedioEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_MEDIO")
	private long idMedio;

	private String descripcion;

	private BigDecimal estado;

	//bi-directional many-to-one association to Contacto
	@OneToMany(mappedBy="medio")
	private List<ContactoEntity> contactos;

	public MedioEntity() {
	}
	
	public MedioEntity(long idMedio, String descripcion, BigDecimal estado) {
		this.idMedio = idMedio;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public long getIdMedio() {
		return this.idMedio;
	}

	public void setIdMedio(long idMedio) {
		this.idMedio = idMedio;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getEstado() {
		return this.estado;
	}

	public void setEstado(BigDecimal estado) {
		this.estado = estado;
	}

	public List<ContactoEntity> getContactos() {
		return this.contactos;
	}

	public void setContactos(List<ContactoEntity> contactos) {
		this.contactos = contactos;
	}

	public ContactoEntity addContacto(ContactoEntity contacto) {
		getContactos().add(contacto);
		contacto.setMedio(this);

		return contacto;
	}

	public ContactoEntity removeContacto(ContactoEntity contacto) {
		getContactos().remove(contacto);
		contacto.setMedio(null);

		return contacto;
	}

}