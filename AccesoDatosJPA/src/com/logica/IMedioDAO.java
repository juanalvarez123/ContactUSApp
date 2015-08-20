package com.logica;

import java.util.List;
import javax.ejb.Local;
import com.modelo.MedioEntity;

@Local
public interface IMedioDAO {
	
	public List<MedioEntity> consultarMedios(MedioEntity medio);

}
