package br.com.guiaturistico.bean;

import java.util.Date;

public class Usuario {
	private int cdUsuario;
	private String nmNome;
	private String nmSobrenome;
	private String nmLogin;
	private String nmSenha;
	private String nmEmail;
	private String bbFoto;
	private Date dtNascimento;
	private int cdTipoUsuario;
	private String nmTipoUsuario;

	public Usuario(int cdUsuario, String nmNome, String nmSobrenome,
			String nmLogin, String nmSenha, String nmEmail, String bbFoto,
			Date dtNascimento, int cdTipoUsuario, String nmTipoUsuario) {
		super();
		this.cdUsuario = cdUsuario;
		this.nmNome = nmNome;
		this.nmSobrenome = nmSobrenome;
		this.nmLogin = nmLogin;
		this.nmSenha = nmSenha;
		this.nmEmail = nmEmail;
		this.bbFoto = bbFoto;
		this.dtNascimento = dtNascimento;
		this.cdTipoUsuario = cdTipoUsuario;
		this.nmTipoUsuario = nmTipoUsuario;
	}

	public int getCdUsuario() {
		return cdUsuario;
	}

	public void setCdUsuario(int cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

	public String getNmNome() {
		return nmNome;
	}

	public void setNmNome(String nmNome) {
		this.nmNome = nmNome;
	}

	public String getNmSobrenome() {
		return nmSobrenome;
	}

	public void setNmSobrenome(String nmSobrenome) {
		this.nmSobrenome = nmSobrenome;
	}

	public String getNmLogin() {
		return nmLogin;
	}

	public void setNmLogin(String nmLogin) {
		this.nmLogin = nmLogin;
	}

	public String getNmSenha() {
		return nmSenha;
	}

	public void setNmSenha(String nmSenha) {
		this.nmSenha = nmSenha;
	}

	public String getNmEmail() {
		return nmEmail;
	}

	public void setNmEmail(String nmEmail) {
		this.nmEmail = nmEmail;
	}

	public String getBbFoto() {
		return bbFoto;
	}

	public void setBbFoto(String bbFoto) {
		this.bbFoto = bbFoto;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
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