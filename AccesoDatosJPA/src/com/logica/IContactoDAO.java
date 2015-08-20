package com.logica;

import javax.ejb.Local;
import com.modelo.ContactoEntity;
import java.util.List;

@Local
public interface IContactoDAO {
	
	public List<ContactoEntity> consultarContactos();
	
	public boolean registrarContacto(ContactoEntity contacto);

}
