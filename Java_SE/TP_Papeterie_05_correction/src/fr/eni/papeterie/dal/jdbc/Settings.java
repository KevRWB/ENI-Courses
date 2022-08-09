package fr.eni.papeterie.dal.jdbc;

import java.io.IOException;
import java.util.Properties;

public class Settings {

	private static Properties properties;
	
	static {
		properties = new Properties();
		try {
			properties.load(Settings.class.getResourceAsStream("settings.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getValue(String key) {
		if(!properties.containsKey(key)) {
			System.err.println("la propriété "+ key +" dans le fichier settings.properties est introuvable");
		}
		
		return properties.getProperty(key);
	}
}
