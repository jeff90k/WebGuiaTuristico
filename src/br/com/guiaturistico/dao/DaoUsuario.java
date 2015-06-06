package br.com.guiaturistico.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.guiaturistico.bean.Categoria;
import br.com.guiaturistico.bean.TipoUsuario;
import br.com.guiaturistico.bean.Usuario;

public class DaoUsuario {
	private ConnectionSingleton Singleton = ConnectionSingleton.getInstance();
	private Connection conn = Singleton.getConnection();

	public DaoUsuario() {
	}
	
	public void addUser(Usuario user) {
		try {
			// recria a conexão Singleton
			Singleton = ConnectionSingleton.getInstance();
			Connection conn = Singleton.getConnection();
			
			PreparedStatement stmt = conn
					.prepareStatement("{ call pAddUser(?,?,?,?,?,?,?) }");
			stmt.setString(1, user.getNmNome());
			stmt.setString(2, user.getNmSobrenome());
			stmt.setDate(3, (Date)user.getDtNascimento());
			stmt.setString(4, user.getNmLogin());
			stmt.setString(5, user.getNmSenha());
			stmt.setString(6, user.getNmEmail());
			stmt.setInt(7, user.getCdTipoUsuario());
			
			// abre box perguntado se deseja listar as categorias
			Object[] options = { "Gravar", "Cancelar" };
			int opcao = JOptionPane.showOptionDialog(null, 
					"Deseja gravar as informações?"
							+"\nNome Completo: "+user.getNmNome()
							+ "\nSobrenome: "+user.getNmSobrenome()
							+ "\nData de Nascimento: "+user.getDtNascimento()
			    			+ "\nLogin: "+user.getNmLogin()
					    	+ "\nSenha: "+user.getNmSenha()
					    	+ "\nE-mail: "+user.getNmEmail()
					    	+ "\nFoto: "+user.getBbFoto()
					    	+ "\nCódigo TipoUsuario: "+user.getCdTipoUsuario(),
					    	"Cadastramento de Usuários.", 
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

	public ArrayList<Usuario> getAllUser() {
		ArrayList<Usuario> resultado = new ArrayList<Usuario>();
		try {
			// recria a conexão Singleton
			Singleton = ConnectionSingleton.getInstance();
			Connection conn = Singleton.getConnection();
			
			// busca o dado e retorna no objeto / arrayList

			// prepara o comendo SQL
			PreparedStatement stmt = conn
					.prepareStatement("{call pGetAllUser()}");

			// executando a query
			ResultSet rs = stmt.executeQuery();

			// montando o ArrayList
			while (rs.next()) {
				// cria o item da biblioteca e armazena no ArrayList
				resultado.add(new Usuario(
						rs.getInt("cdUsuario"),
						rs.getString("nmNome"),
						rs.getString("nmSobrenome"),
						rs.getString("nmLogin"),
						rs.getString("nmSenha"),
						rs.getString("nmEmail"),
						rs.getString("bbFoto"),
						rs.getDate("dtNascimento"),
						0,
						null));
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
	
	public ArrayList<Usuario> getUserByName(Usuario user){
		ArrayList<Usuario> resultado = new ArrayList <Usuario>();
		
		try{
			// recria a conexão Singleton
			Singleton = ConnectionSingleton.getInstance();
			Connection conn = Singleton.getConnection();
			
			// prepara o comendo SQL
			PreparedStatement stmt = conn
					.prepareStatement("{call pGetUserByName(?)}");
			stmt.setString(1, user.getNmLogin());

			// executando a query
			ResultSet rs = stmt.executeQuery();

			// montando o ArrayList
			while (rs.next()) {
				// cria o item da biblioteca e armazena no ArrayList
				resultado.add(
						new Usuario(
								rs.getInt("cdUsuario"),
								rs.getString("nmNome"),
								rs.getString("nmSobrenome"),
								rs.getString("nmLogin"),
								rs.getString("nmSenha"),
								rs.getString("nmEmail"),
								rs.getString("bbFoto"),
								rs.getDate("dtNascimento"),
								rs.getInt("cdTipoUsuario"),
								rs.getString("nmTIpoUsuario")));
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
	
	public void editUser(Usuario user) {
		try {
			// fechar a conexão Singleton
			Singleton = ConnectionSingleton.getInstance();
			Connection conn = Singleton.getConnection();
			
			PreparedStatement stmt = conn
					.prepareStatement("{ call pEdtUser(?,?,?,?,?,?,?) }");
			stmt.setString(1, user.getNmNome());
			stmt.setString(2, user.getNmSobrenome());
			stmt.setDate(3, (Date)user.getDtNascimento());
			stmt.setString(4, user.getNmLogin());
			stmt.setString(5, user.getNmSenha());
			stmt.setString(6, user.getNmEmail());
			stmt.setInt(7, user.getCdTipoUsuario());
			
			// abre box perguntado se deseja listar as categorias
			Object[] options = { "Gravar", "Cancelar" };
			int opcao = JOptionPane.showOptionDialog(null, 
					"Deseja gravar as informações?"
							+"\nNome Completo: "+user.getNmNome()
							+ "\nSobrenome: "+user.getNmSobrenome()
							+ "\nData de Nascimento: "+user.getDtNascimento()
			    			+ "\nLogin: "+user.getNmLogin()
					    	+ "\nSenha: "+user.getNmSenha()
					    	+ "\nE-mail: "+user.getNmEmail()
					    	+ "\nFoto: "+user.getBbFoto()
					    	+ "\nCódigo TipoUsuario: "+user.getCdTipoUsuario(),
					    	"Alteração de Usuários.", 
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
	
	public ArrayList<Usuario> getAllUserWithType() {
		ArrayList<Usuario> resultado = new ArrayList<Usuario>();
		try {
			// recria a conexão Singleton
			Singleton = ConnectionSingleton.getInstance();
			Connection conn = Singleton.getConnection();

			// prepara o comendo SQL
			PreparedStatement stmt = conn
					.prepareStatement("{call pGetAllUserWithType()}");

			// executando a query
			ResultSet rs = stmt.executeQuery();

			// montando o ArrayList
			while (rs.next()) {
				// cria o item da biblioteca e armazena no ArrayList
				resultado.add(new Usuario(
						rs.getInt("cdUsuario"),
						rs.getString("nmNome"),
						rs.getString("nmSobrenome"),
						rs.getString("nmLogin"),
						rs.getString("nmSenha"),
						rs.getString("nmEmail"),
						rs.getString("bbFoto"),
						rs.getDate("dtNascimento"),
						rs.getInt("cdTipoUsuario"),
						rs.getString("nmTIpoUsuario")));
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
	
	public ArrayList<TipoUsuario> getAllTipoUsua() {
		ArrayList<TipoUsuario> resultado = new ArrayList<TipoUsuario>();
		try {
			// recria a conexão Singleton
			Singleton = ConnectionSingleton.getInstance();
			Connection conn = Singleton.getConnection();
			
			// prepara o comendo SQL
			PreparedStatement stmt = conn
					.prepareStatement("{call pGetAllTipoUsua()}");

			// executando a query
			ResultSet rs = stmt.executeQuery();

			// montando o ArrayList
			while (rs.next()) {
				// cria o item da biblioteca e armazena no ArrayList
				resultado.add(new TipoUsuario(
						rs.getInt("cdTipoUsuario"),
						rs.getString("nmTpoUsuario")));
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
