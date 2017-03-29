package br.com.laboratorio.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	private final static String DRIVER = "org.postgresql.Driver";
	private final static String URL = "jdbc:postgresql://localhost:5432/bd_imc";
	private final static String USER = "postgres";
	private final static String PASSWORD = "12345";
	
	public Connection getConnection(){
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e){
			System.err.println("---------------------------------------");
			System.err.println("ERRO: Erro na ConnectionFactory");
			e.printStackTrace();
		}
		return null;
	}
}
