package br.edu.utfpr.cep.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private Connection connection;
	private static Conexao instance = null;
	
	public static synchronized Conexao getInstance() throws SQLException{
		if((Conexao.instance == null) || (Conexao.instance.connection == null)){
			Conexao.instance = new Conexao();
		}
		
		return Conexao.instance;
	}
	
	private Conexao() throws SQLException{
		DriverManager.registerDriver(new org.sqlite.JDBC());
		this.connection = DriverManager.getConnection("jdbc:sqlite:" + this.getClass().getClassLoader().getResource("cidades.db3").getPath());
	}
	
	public Connection getConexao() throws SQLException{
		return this.connection;
	}

}
