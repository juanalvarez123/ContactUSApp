package com.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import com.logica.*;
import com.modelo.*;

import java.sql.SQLException;
import java.util.*;

@Path("/wsPersonas")
public class WsPersonas {
	
	//@EJB
	//PersonaDAO personaDAO;
	
	@Path("{nombrePersona}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String obtenerSaludo(@PathParam("nombrePersona") String nombrePersona) {
		return "Bienvenido !! " + nombrePersona;
	}
	
	@GET
	@Path("consultarPersonas")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	/*public List<PersonaEntity> consultarPersonas() {		
		List<PersonaEntity> lstPersonas = personaDAO.consultarPersonas();
		return lstPersonas;
	}*/
	public List<Persona> consultarPersonas() throws SQLException {
		PersonaDALC personaDALC = new PersonaDALC();
		List<Persona> lstPersonas = personaDALC.consultarPersonas();
		return lstPersonas;
	}
	
	@POST
	@Path("registrarPersona")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	/*public String registrarPersona(PersonaEntity persona) {
		return String.valueOf(personaDAO.registrarPersona(persona));
	}*/
	public String registrarPersona(JAXBElement<Persona> persona) throws SQLException {
		PersonaDALC personaDALC = new PersonaDALC();
		boolean respuesta = personaDALC.registrarPersona(persona.getValue());
		return String.valueOf(respuesta);
	}

}