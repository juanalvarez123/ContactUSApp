package com.logica;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.modelo.ContactoEntity;

@Stateless
public class ContactoDAO implements IContactoDAO {
	
	@PersistenceContext(unitName = "AccesoDatosJPA")
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ContactoEntity> consultarContactos() {
		return (List<ContactoEntity>) em.createNamedQuery("ContactoEntity.findAll").getResultList();
	}
	
	@Override
	public boolean registrarContacto(ContactoEntity contacto) {
		try {
			em.persist(contacto);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

}