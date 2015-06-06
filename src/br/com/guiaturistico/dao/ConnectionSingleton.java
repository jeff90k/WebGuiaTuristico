package br.com.guiaturistico.dao;

import java.sql.*;

public final class ConnectionSingleton {
	private Connection conn;
	private String url = "jdbc:jtds:sqlserver://localhost:1433/";
	private String database = "GuiaTuristico";
	private String driver = "net.sourceforge.jtds.jdbc.Driver";
	private String usuario = "";
	private String senha = "";
	public static ConnectionSingleton instance;

	private ConnectionSingleton() {
		try{
			// adicionar o driver ao buildpath
			Class.forName(this.driver);
	
			// carregar o driver
			conn = DriverManager.getConnection(this.url+this.database, usuario, senha);
		} catch(ClassNotFoundException ex){
			// não conseguiu carregar o driver
			System.out.println("Classe não encontrada: Nenhum Driver encontrado.");
		} catch(SQLException ex){
			// erro em algum SQL ou na abertura da conexão
			System.out.println("Exceção no comando SQL: "+ ex.getMessage()+
					"\nErro: "+ex.getErrorCode());
		}
	}

	public static synchronized ConnectionSingleton getInstance() {
		if (instance == null) {
			instance = new ConnectionSingleton();
		}
		return instance;
	}
	
	public Connection getConnection(){
		return this.conn;
	}
}