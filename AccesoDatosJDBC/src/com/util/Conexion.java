package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

	private static String DBDRIVER = "";

	private static BaseDeDatos bd;

	static {
		try {
			Propiedades prop = new Propiedades();
			DBDRIVER = prop.obtenerValor("base.datos.driver");
			String nombreBD = prop.obtenerValor("base.datos");
			if(nombreBD.equals(BaseDeDatos.ORACLE.toString())) {
				bd = BaseDeDatos.ORACLE;
			} else if (nombreBD.equals(BaseDeDatos.POSTGRESQL.toString())) {
				bd = BaseDeDatos.POSTGRESQL;
			}
		    Class.forName(DBDRIVER).newInstance();
		} catch (Exception e){
		    e.printStackTrace();
		}
	}

	public static Connection obtenerConexion()
	{
		Connection connection = null;
		try {
		    connection = DriverManager.getConnection(bd.URL(), bd.USER(), bd.PASSWORD());
		}
		catch (Exception e) {
		    e.printStackTrace();
		}
		return connection;
	}

	public static BaseDeDatos obtenerBaseDeDatos() {
		return bd;
	}

}