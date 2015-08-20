package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "pruebas";
	private static final String PASSWORD = "pruebas";
	private static final String DBDRIVER = "oracle.jdbc.OracleDriver";
	
	static {
		try {
		    Class.forName(DBDRIVER).newInstance();
		} catch (Exception e){
		    e.printStackTrace();
		}
	}
	
	public static Connection obtenerConexion() 
	{
		Connection connection = null;
		try {
		    connection = DriverManager.getConnection(URL, USER, PASSWORD);
		}
		catch (Exception e) {
		    e.printStackTrace();
		}
		return connection;
	}

}