package br.edu.infnet.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private static Connection conn = null;
	
	public static Connection obterConexao(){

		if (conn == null){

			String serverName = "localhost";			
			String bancoDados = "dbInfnet";      				
			String url = "jdbc:mysql://" + serverName + "/" + bancoDados + "?useTimezone=true&serverTimezone=UTC";				
			String usuario = "root";              				
			String senha = "";

			try {
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				conn = DriverManager.getConnection(url, usuario, senha);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
		return conn;
	}
}