package model;

public class Copertina {
	private Long id_lp;
	private String url_copertina;
	
	public Copertina() {
		
	}
	public Copertina(Long id_lp) {
		this.id_lp = id_lp;
	}
	public Copertina(Long id_lp,String url) {
		this.id_lp = id_lp;
		this.url_copertina = url;
	}
	public Long getId() {
		return this.id_lp;
	}
	public String getCopertina() {
		return this.url_copertina;
	}
	public void setId(long c) {
		this.id_lp = c;
	}
	public void setCopertina(String u) {
		this.url_copertina = u;
	}
}
