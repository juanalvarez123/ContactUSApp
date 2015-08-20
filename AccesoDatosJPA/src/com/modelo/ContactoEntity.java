package com.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the CONTACTO database table.
 * 
 */
@XmlRootElement
@Entity
@Table(name = "CONTACTO")
@NamedQuery(name="ContactoEntity.findAll", query="SELECT c FROM ContactoEntity c")
public class ContactoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CONTACTO")
	private long idContacto;

	private String apellidos;

	private String comentarios;

	private String email;

	private String nombres;

	private String pais;

	private String respuesta;

	private String telefono;

	private String url;

	//bi-directional many-to-one association to Medio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_MEDIO")
	private MedioEntity medio;

	public ContactoEntity() {
	}

	public long getIdContacto() {
		return this.idContacto;
	}

	public void setIdContacto(long idContacto) {
		this.idContacto = idContacto;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getRespuesta() {
		return this.respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public MedioEntity getMedio() {
		return this.medio;
	}

	public void setMedio(MedioEntity medio) {
		this.medio = medio;
	}

}