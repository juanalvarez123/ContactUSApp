package com.logica;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.modelo.Persona;
import com.util.Conexion;

import oracle.jdbc.OracleTypes;

public class PersonaDALC {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Persona> consultarPersonas() throws SQLException {
		List<Persona> lstPersonas = new ArrayList();
		Connection con = Conexion.obtenerConexion();
        CallableStatement cs = null;
        try {
            cs = con.prepareCall("{call PKG_PERSONAS.CONSULTAR_PERSONAS(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeUpdate();
            ResultSet rs = (ResultSet) cs.getObject(1);
            while (rs.next()) {
                Persona persona = new Persona();
                persona.id = rs.getInt("ID");
                persona.identificacion = rs.getInt("IDENTIFICACION");
                persona.nombre = rs.getString("NOMBRE");                
                persona.edad = rs.getInt("EDAD");
                lstPersonas.add(persona);
            }
        } catch (Exception ex) {
            return null;
        } finally {
            if (cs != null) {
                cs.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return lstPersonas;
	}
	
	public boolean registrarPersona(Persona persona) throws SQLException {
		Connection con = Conexion.obtenerConexion();
		CallableStatement cs = null;
		try {
			cs = con.prepareCall("{ call PKG_PERSONAS.REGISTRAR_PERSONA(?,?,?,?) }");
			cs.setInt(1, persona.id);
			cs.setInt(2, persona.identificacion);
			cs.setString(3, persona.nombre);
			cs.setInt(4, persona.edad);
			cs.executeUpdate();
		} catch (Exception ex) {
			return false;
		} finally {
			if(con != null) {
				con.close();
			}
			if(cs != null) {
				cs.close();
			}
		}
		return true;
	}

}
