package com.servicios;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.logica.ContactoDALC;
import com.logica.MedioDALC;
import com.modelo.Contacto;
import com.modelo.Medio;

import java.sql.SQLException;
import java.util.List;

@Path("/wsContactUs")
public class WsContactUs {
	
	@GET
	@Path("consultarMedios/{estado}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Medio> consultarMedios(@PathParam("estado") int estado) throws SQLException	{
		MedioDALC medioDALC = new MedioDALC();
		List<Medio> lstMedios = medioDALC.consultarMedios(new Medio(null, null, estado));
		return lstMedios;
	}
	
	@GET
	@Path("consultarContactos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Contacto> consultarContactos() throws SQLException {
		ContactoDALC contactoDALC = new ContactoDALC();
		List<Contacto> lstContactos = contactoDALC.consultarContactos();
		return lstContactos;
	}
	
	@POST
	@Path("registrarContacto")
	@Produces(MediaType.APPLICATION_JSON)
	public String registrarContacto(Contacto contacto) throws SQLException {
		ContactoDALC contactoDALC = new ContactoDALC();		
		boolean respuesta = contactoDALC.registrarContacto(contacto);
		return String.valueOf(respuesta);
	}
	
}