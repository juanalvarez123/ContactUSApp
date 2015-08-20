package com.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

/**
 * The persistent class for the PERSONA database table.
 * 
 */
@XmlRootElement
@Entity
@Table(name="PERSONA")
@NamedQuery(name="PersonaEntity.findAll", query="SELECT p FROM PersonaEntity p")
public class PersonaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private BigDecimal edad;

	private BigDecimal identificacion;

	private String nombre;

	public PersonaEntity() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getEdad() {
		return this.edad;
	}

	public void setEdad(BigDecimal edad) {
		this.edad = edad;
	}

	public BigDecimal getIdentificacion() {
		return this.identificacion;
	}

	public void setIdentificacion(BigDecimal identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}