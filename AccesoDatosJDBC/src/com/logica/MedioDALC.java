package com.logica;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import com.modelo.Medio;
import com.util.BaseDeDatos;
import com.util.Conexion;

import oracle.jdbc.OracleTypes;

public class MedioDALC {

	private BaseDeDatos baseDeDatos;

	public MedioDALC() {
		baseDeDatos = Conexion.obtenerBaseDeDatos();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Medio> consultarMedios(Medio medio) throws SQLException {
		List<Medio> lstMedios = new ArrayList();
		Connection con = Conexion.obtenerConexion();
		CallableStatement cs = null;
		try {
			ResultSet rs = null;
			if(baseDeDatos.equals(BaseDeDatos.ORACLE)) {
				cs = con.prepareCall("{ call PKG_MEDIOS.CONSULTAR_MEDIOS(?,?) }");
				cs.setInt(1, medio.estado);
				cs.registerOutParameter(2, OracleTypes.CURSOR);
				cs.executeUpdate();
				rs = (ResultSet) cs.getObject(2);
			} else if (baseDeDatos.equals(BaseDeDatos.POSTGRESQL)) {
				con.setAutoCommit(false);
				cs = con.prepareCall("{ ? = call CONSULTAR_MEDIOS(?) }");
				cs.registerOutParameter(1, Types.OTHER);
				cs.setInt(2, medio.estado);
				cs.executeUpdate();
				rs = (ResultSet) cs.getObject(1);
			}
			if(rs != null) {
				while (rs.next()) {
					Medio newMedio = new Medio();
					newMedio.idMedio = rs.getInt("ID_MEDIO");
					newMedio.descripcion = rs.getString("DESCRIPCION").trim();
					newMedio.estado = rs.getInt("ESTADO");
					lstMedios.add(newMedio);
				}
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
		return lstMedios;
	}

}