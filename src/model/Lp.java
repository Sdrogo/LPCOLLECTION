package model;

import java.sql.Connection;

import persistence.IdBroker;

public class Lp implements Comparable<Lp> {

	private Long id_lp;
	private String titolo;
	private Long id_gruppo;
	private String genere;
	private int anno;
	public Lp(Connection connection) {
		this.id_lp = IdBroker.getId(connection);
	}

	public Lp() {

	}

	public Lp(Connection connection, String titolo, int anno, String genere, Long id_gruppo) {
		this.id_lp = IdBroker.getId(connection);
		this.titolo = titolo;
		this.anno = anno;
		this.genere = genere;
		this.id_gruppo = id_gruppo;
	}

	public Long getId() {
		return this.id_lp;
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

	public Long getIdGruppo() {
		return this.id_gruppo;
	}

	public void setIdGruppo(Long g) {
		this.id_gruppo = g;
	}

	public void setId(long c) {
		this.id_lp = c;
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

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer("LP [");
		str.append("ID : " + this.getId() + ", " + this.getTitolo() + "]\n");
		return str.toString();
	}

	@Override
	public int compareTo(Lp arg0) {
		Integer l1 = this.getAnno();
		Integer l2 = arg0.getAnno();

		return l1.compareTo(l2);
	}
}
