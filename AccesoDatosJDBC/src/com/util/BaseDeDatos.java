package com.util;

public enum BaseDeDatos {

	ORACLE("jdbc:oracle:thin:@localhost:1521:xe", "pruebas", "pruebas"),
	POSTGRESQL("jdbc:postgresql://localhost:5432/pruebas", "postgres", "postgres");

	/*private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "pruebas";
	private static final String PASSWORD = "pruebas";
	private static final String DBDRIVER = "oracle.jdbc.OracleDriver";*/

	/*Class.forName("org.postgresql.Driver");
	Connection connection = null;
	connection = DriverManager.getConnection(
	   "jdbc:postgresql://hostname:port/dbname","username", "password");
	connection.close();*/

	private String url;
	private String user;
	private String password;

	private BaseDeDatos(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}

	public String URL() {
		return this.url;
	}

	public String USER() {
		return this.user;
	}

	public String PASSWORD() {
		return this.password;
	}

}
