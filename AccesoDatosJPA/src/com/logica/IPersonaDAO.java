package com.logica;

import javax.ejb.Local;
import com.modelo.PersonaEntity;
import java.util.*;

@Local
public interface IPersonaDAO {
	
	public List<PersonaEntity> consultarPersonas();
	
	public boolean registrarPersona(PersonaEntity persona);

}
