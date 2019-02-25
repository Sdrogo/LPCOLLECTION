package model;

import java.sql.Connection;

import persistence.IdBroker;

public class Lp implements Comparable<Lp> {

	private Long id;
	private String titolo;
	private Long id_gruppo;
	private String genere;
	private int anno;
	private String copertina;
	private String nome_gruppo;

	public Lp(Connection connection) {
		this.id = IdBroker.getId(connection);
	}

	public Lp() {

	}

	public Lp(Connection connection, String titolo, int anno, String genere, String copertina, Long id_gruppo,
			String nome_gruppo) {
		this.id = IdBroker.getId(connection);
		this.titolo = titolo;
		this.anno = anno;
		this.genere = genere;
		this.copertina = copertina;
		this.id_gruppo = id_gruppo;
		this.nome_gruppo = nome_gruppo;
	}

	public Long getId() {
		return this.id;
	}

	public String getTitolo() {
		return this.titolo;
	}

	public String getGenere() {
		return this.genere;
	}

	public int getAnno() {
		return this.anno;
	}

	public String getCopertina() {
		return this.copertina;
	}

	public Long getIdGruppo() {
		return this.id_gruppo;
	}

	public void setIdGruppo(Long g) {
		this.id_gruppo = g;
	}

	public void setId(long c) {
		this.id = c;
	}

	public void setTitolo(String c) {
		this.titolo = c;
	}

	public void setGenere(String c) {
		this.genere = c;
	}

	public void setAnno(int a) {
		this.anno = a;
	}

	public void setCopertina(String u) {
		this.copertina = u;
	}

	public String getNomeGruppo() {
		return this.nome_gruppo;
	}

	public void setNomeGrupo(String s) {
		this.nome_gruppo = s;
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer("LP [");
		str.append("ID : " + this.getId() + ", " + this.getTitolo() + "]\n" + this.copertina);
		return str.toString();
	}

	@Override
	public int compareTo(Lp arg0) {
		Integer l1 = this.getAnno();
		Integer l2 = arg0.getAnno();
		
		return l1.compareTo(l2);
	}
}
