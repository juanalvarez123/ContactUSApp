package com.logica;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.modelo.Contacto;
import com.modelo.Medio;
import com.util.Conexion;

import oracle.jdbc.OracleTypes;

public class ContactoDALC {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Contacto> consultarContactos() throws SQLException {
		List<Contacto> lstContactos = new ArrayList();
		Connection con = Conexion.obtenerConexion();
		CallableStatement cs = null;
		try {
			cs = con.prepareCall("{ call PKG_CONTACTOS.CONSULTAR_CONTACTOS(?) }");
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.executeUpdate();
			ResultSet rs = (ResultSet) cs.getObject(1);
			while (rs.next()) {
				Contacto contacto = new Contacto();
				contacto.idContacto = rs.getInt("ID_CONTACTO");
				contacto.nombres = rs.getString("NOMBRES");
				contacto.apellidos = rs.getString("APELLIDOS");
				contacto.email = rs.getString("EMAIL");
				contacto.telefono = rs.getString("TELEFONO");
				contacto.pais = rs.getString("PAIS");
				contacto.url = rs.getString("URL");
				contacto.medio = new Medio(rs.getInt("ID_MEDIO"), rs.getString("DESCRIPCION_MEDIO"), null);
				contacto.comentarios = rs.getString("COMENTARIOS");
				contacto.respuesta = rs.getString("RESPUESTA");
				contacto.nombreCompleto = contacto.nombres + " " + contacto.apellidos;
				lstContactos.add(contacto);
			}
		} catch (Exception ex) {
			return null;
		} finally {
			if (con != null) {
				con.close();
			}
			if (cs != null) {
				cs.close();
			}
		}
		return lstContactos;
	}
	
	public boolean registrarContacto(Contacto contacto) throws SQLException {
		Connection con = Conexion.obtenerConexion();
		CallableStatement cs = null;
		try {
			cs = con.prepareCall("{ call PKG_CONTACTOS.REGISTRAR_CONTACTO(?,?,?,?,?,?,?,?,?) }");
			cs.setString(1, contacto.nombres);
			cs.setString(2, contacto.apellidos);
			cs.setString(3, contacto.email);
			cs.setString(4, contacto.telefono);
			cs.setString(5, contacto.pais);
			cs.setString(6, contacto.url);
			cs.setInt(7, contacto.medio.idMedio);
			cs.setString(8, contacto.comentarios);
			cs.setString(9, contacto.respuesta);
			cs.executeUpdate();
		} catch (Exception ex) {
			return false;
		} finally {
			if (con != null) {
				con.close();
			}
			if (cs != null) {
				cs.close();
			}
		}
		return true;
	}

}