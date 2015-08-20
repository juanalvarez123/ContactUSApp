package com.logica;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import com.modelo.PersonaEntity;

import java.util.*;

@Stateless
public class PersonaDAO implements IPersonaDAO {
	
	//@PersistenceUnit(unitName = "AccesoDatos")
	@PersistenceContext(unitName = "AccesoDatos")
	private EntityManager em;
	
	//@PersistenceUnit(unitName="AccesoDatos")
    //private EntityManagerFactory emf;
	
	public PersonaDAO() { 
		//EntityManagerFactory factory = Persistence.createEntityManagerFactory("AccesoDatos");
		//em = factory.createEntityManager();
		//em = emf.createEntityManager();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<PersonaEntity> consultarPersonas() {
		return (List<PersonaEntity>) em.createNamedQuery("PersonaEntity.findAll").getResultList();
	}
	
	@Override
	public boolean registrarPersona(PersonaEntity persona) {
		try {
			em.persist(persona);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

}