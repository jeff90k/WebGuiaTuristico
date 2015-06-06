package br.com.guiaturistico.bean;

public class Categoria {
	private int cdCategoria;
	private String nmCategoria;
	private String nmIcon;
	private String nmTitle;
	
	public Categoria(int cdCategoria, String nmCategoria, String nmIcon,
			String nmTitle) {
		super();
		// cdCategoria � autonumerico no banco. N�o � necess�rio setar
		this.cdCategoria = cdCategoria;
		this.nmCategoria = nmCategoria;
		this.nmIcon = nmIcon;
		this.nmTitle = nmTitle;
	}
	
	@Override
	public String toString() {
		return "\nC�digo: " + cdCategoria
				+ "\nNome: "+ nmCategoria
				+ "\nIcon: " + nmIcon
				+ "\nTitle: " + nmTitle;
	}

	public int getCdCategoria() {
		return cdCategoria;
	}
	public void setCdCategoria(int cdCategoria) {
		this.cdCategoria = cdCategoria;
	}

	public String getNmCategoria() {
		return nmCategoria;
	}
	public void setNmCategoria(String nmCategoria) {
		this.nmCategoria = nmCategoria;
	}

	public String getNmIcon() {
		return nmIcon;
	}
	public void setNmIcon(String nmIcon) {
		this.nmIcon = nmIcon;
	}

	public String getNmTitle() {
		return nmTitle;
	}
	public void setNmTitle(String nmTitle) {
		this.nmTitle = nmTitle;
	}
}
