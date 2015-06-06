package br.com.guiaturistico.bean;

public class TipoUsuario {
	public int cdTipoUsuario;
	public String nmTipoUsuario;
	
	public TipoUsuario(int cdTipoUsuario, String nmTipoUsuario) {
		super();
		this.cdTipoUsuario = cdTipoUsuario;
		this.nmTipoUsuario = nmTipoUsuario;
	}

	@Override
	public String toString() {
		return "Código do Tipo Usuario: " + cdTipoUsuario+
				"Nome do Tipo Usuario:" + nmTipoUsuario;
	}

	public int getCdTipoUsuario() {
		return cdTipoUsuario;
	}

	public void setCdTipoUsuario(int cdTipoUsuario) {
		this.cdTipoUsuario = cdTipoUsuario;
	}

	public String getNmTipoUsuario() {
		return nmTipoUsuario;
	}

	public void setNmTipoUsuario(String nmTipoUsuario) {
		this.nmTipoUsuario = nmTipoUsuario;
	}
}