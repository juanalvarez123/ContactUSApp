package com.util;

import java.io.InputStream;
import java.util.Properties;

public class Propiedades {

	Properties prop = new Properties();
	InputStream input = null;

	public Propiedades() {
		String nombre = "propiedades.properties";
		input = Propiedades.class.getClassLoader().getResourceAsStream(nombre);
		if(input == null) {
			System.out.println("No es posible encontrar el archivo " + nombre);
			return;
		} else {
			try {
				prop.load(input);
			} catch(Exception ex) {
				return;
			}
		}
	}

	public String obtenerValor(String nombrePropiedad) {
		return prop.getProperty(nombrePropiedad);
	}

}
