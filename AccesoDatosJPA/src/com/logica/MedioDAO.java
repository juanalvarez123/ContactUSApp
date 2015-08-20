package com.logica;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.modelo.MedioEntity;

@Stateless
public class MedioDAO implements IMedioDAO {

	@PersistenceContext(unitName = "AccesoDatosJPA")
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MedioEntity> consultarMedios(MedioEntity medio) {
		return (List<MedioEntity>) em.createNamedQuery("").setParameter(":estado", medio.getEstado()).getResultList();		
	}

}