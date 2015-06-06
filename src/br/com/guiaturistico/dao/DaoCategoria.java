package br.com.guiaturistico.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.guiaturistico.bean.Categoria;

public class DaoCategoria {
	private ConnectionSingleton Singleton = ConnectionSingleton.getInstance();
	private Connection conn = Singleton.getConnection();

	public DaoCategoria(){
	}

	public ArrayList<Categoria> getAllCategPerPage(int page, int perPage) {
		ArrayList<Categoria> resultado = new ArrayList<Categoria>();

		try {
			// recria a conexão Singleton
			Singleton = ConnectionSingleton.getInstance();
			Connection conn = Singleton.getConnection();
			// prepara o comendo SQL
			PreparedStatement stmt = conn
					.prepareStatement("{call pGetAllCategPerPage(?,?)}");
			stmt.setInt(1, page);
			stmt.setInt(2, perPage);

			// executando a query
			ResultSet rs = stmt.executeQuery();

			// montando o ArrayList
			while (rs.next()) {
				// cria o item da biblioteca e armazena no ArrayList
				resultado.add(new Categoria(
						rs.getInt("cdCategoria"),
						rs.getString("nmCategoria"),
						rs.getString("nmIcon"),
						rs.getString("nmTitle")));
				br.com.guiaturistico.servlet.CategController.pages = rs.getInt("registros");
			}
			return resultado;
		} catch (SQLException exSQL) {
			System.out.println("Erro no acesso aos dados. Código: "
					+ exSQL.getMessage());
			return null;
		} finally{
			disconnect();
		}
	}
	
	public ArrayList<Categoria> getAllCateg() {
		ArrayList<Categoria> resultado = new ArrayList<Categoria>();

		try {
			// recria a conexão Singleton
			Singleton = ConnectionSingleton.getInstance();
			Connection conn = Singleton.getConnection();
			// prepara o comendo SQL
			PreparedStatement stmt = conn
					.prepareStatement("{call pGetAllCateg()}");
			// executando a query
			ResultSet rs = stmt.executeQuery();

			// montando o ArrayList
			while (rs.next()) {
				// cria o item da biblioteca e armazena no ArrayList
				resultado.add(new Categoria(
						rs.getInt("cdCategoria"),
						rs.getString("nmCategoria"),
						rs.getString("nmIcon"),
						rs.getString("nmTitle")));
			}
			return resultado;
		} catch (SQLException exSQL) {
			System.out.println("Erro no acesso aos dados. Código: "
					+ exSQL.getMessage());
			return null;
		} finally{
			disconnect();
		}
	}

	public void addCateg(Categoria categ) {
		try {
			// recria a conexão Singleton
			Singleton = ConnectionSingleton.getInstance();
			Connection conn = Singleton.getConnection();
			PreparedStatement stmt = conn
					.prepareStatement("{ call pAddCateg(?,?,?) }");
			stmt.setString(1, categ.getNmCategoria());
			stmt.setString(2, categ.getNmIcon());
			stmt.setString(3, categ.getNmTitle());
			
			// abre box perguntado se deseja listar as categorias
			Object[] options = { "Gravar", "Cancelar" };
			int opcao = JOptionPane.showOptionDialog(null, 
					"Deseja gravar as informações?"
					+ "\nNome: "+categ.getNmCategoria()
					+"\nIcone: "+categ.getNmIcon()
					+ "\nTitle: "+categ.getNmTitle(),
					"Cadastramento de Categoria.", 
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, 
					null,
					options, 
					options[0]);
			 
			  // interpret the user's choice
			  if (opcao == JOptionPane.NO_OPTION){
			    JOptionPane.showMessageDialog(null, "Operação cancelada.");
			  }
			  else{
				  stmt.execute();
			  }
		} catch (SQLException ex) {
			System.out.println("Ocorreu um erro: " + ex.getMessage());
		} finally {
			disconnect();
		}
	}
	
	public ArrayList<Categoria> getCategByName(Categoria categ){
		ArrayList<Categoria> resultado = new ArrayList <Categoria>();
		
		try{
			// recria a conexão Singleton
			Singleton = ConnectionSingleton.getInstance();
			Connection conn = Singleton.getConnection();
			
			// prepara o comendo SQL
			PreparedStatement stmt = conn
					.prepareStatement("{call pGetCategByName(?)}");
			stmt.setString(1, categ.getNmCategoria());

			// executando a query
			ResultSet rs = stmt.executeQuery();

			// montando o ArrayList
			while (rs.next()) {
				// cria o item da biblioteca e armazena no ArrayList
				resultado.add(
						new Categoria(
								rs.getInt("cdCategoria"),
								rs.getString("nmCategoria"),
								rs.getString("nmIcon"),
								rs.getString("nmTitle")));
			}
			return resultado;
		} catch (SQLException exSQL) {
			System.out.println("Erro no acesso aos dados. Código: "
					+ exSQL.getMessage());
			return null;
		} finally {
			disconnect();
		}
	}

	public void editCateg(Categoria categ) {
		try {
			// fechar a conexão Singleton
			Singleton = ConnectionSingleton.getInstance();
			Connection conn = Singleton.getConnection();
			
			PreparedStatement stmt = conn
					.prepareStatement("{ call pEdtCateg(?,?,?,?) }");
			stmt.setInt(1, categ.getCdCategoria());
			stmt.setString(2, categ.getNmCategoria());
			stmt.setString(3, categ.getNmIcon());
			stmt.setString(4, categ.getNmTitle());

			stmt.execute();

		} catch (SQLException ex) {
			System.out.println("Ocorreu um erro: " + ex.getMessage());
		} finally {
			disconnect();
		}
	}
	
	public void disconnect(){
		try{
			// fechar a conexão Singleton
			conn.close();
			ConnectionSingleton.instance = null;
		}catch (SQLException exSQL){
			System.out.println("Erro ao fechar a conexão: " + exSQL.getMessage()+
					"\nErro: "+exSQL.getErrorCode());
		}
	}
}
