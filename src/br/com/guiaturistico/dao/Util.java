package br.com.guiaturistico.dao;

import javax.swing.JOptionPane;

public class Util {
	public static int Menu(){
		String opc = null;
		int submenu = 0;
		while(opc == null){
			opc = JOptionPane.showInputDialog("Menu"
			+ "\n1 - Categoria"
			+ "\n2 - Usuário"
			+ "\n0 - Sair");
			
			submenu = Integer.parseInt(opc);
			if(submenu == 0 || submenu < 0 || submenu > 4)
				opc = null;
		}
		return submenu;
	}
	
	public static int Submenu(){
		String opc = null;
		int menu = 0;
		while(opc == null){
			opc = JOptionPane.showInputDialog("Menu"
			+ "\n1 - Adicionar Registro"
			+ "\n2 - Editar Registro"
			+ "\n3 - Excluir Registro"
			+ "\n4 - Listar Registros"
			+ "\n0 - Sair");
			
			menu = Integer.parseInt(opc);
			if(menu == 0 || menu < 0 || menu > 4)
				opc = null;
		}
		return menu;
	}
}
