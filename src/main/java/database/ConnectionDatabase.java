package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDatabase {
	private static final String url = "jdbc:mysql://localhost:3306/formation";
	private static final String user = "root";
	private static final String pass = "root";
	
	private static Connection connection;
	
	//En mettant le constructeyr eb private, j'interdis la construction d'un objet
	private ConnectionDatabase() {
	}
	
	//Par contre comme la méthode est static je peux l'appeler via la classe
	public static Connection getConnection(){
		if (connection == null);
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(url, user, pass);
			} catch (Exception e) {
				e.printStackTrace();
			}
		return connection;
	}
}
