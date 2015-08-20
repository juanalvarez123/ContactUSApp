package com.modelo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "medio")
public class Medio {
	
	public Medio() { }
	
	public Medio(Integer idMedio, String descripcion, Integer estado) { 
		this.idMedio = idMedio;
		this.descripcion = descripcion;
		this.estado = estado;
	}
	
	public Integer idMedio;
	public String descripcion;
	public Integer estado;

}
