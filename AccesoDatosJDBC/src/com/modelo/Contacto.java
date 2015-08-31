package com.modelo;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Contacto {

	public Integer idContacto;
	public String nombres;
	public String apellidos;
	public String email;
	public String telefono;
	public String pais;
	public String url;
	public Medio medio;
	public String comentarios;
	public String respuesta;
	public Date fechaRegistro;
	public String nombreCompleto;
	public String fechaRegistroString;

}
