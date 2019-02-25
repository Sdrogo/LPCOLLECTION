package model;

import java.sql.Connection;
import persistence.IdBroker;

public class Gruppo implements Comparable<Gruppo> {

	private Long id_gruppo;
	private String nome;

	public Gruppo(Connection connection) {
		this.id_gruppo = IdBroker.getId(connection);
	}

	public Gruppo() {

	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String Nome) {
		this.nome = Nome;
	}

	public Long getId() {
		return this.id_gruppo;
	}

	public void setId(Long i) {
		this.id_gruppo = i;
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer("Gruppo : ");
		str.append(this.getNome());
		str.append("ID : " + this.getId());
		return str.toString();
	}

	@Override
	public int compareTo(Gruppo arg0) {
		return this.nome.compareTo(arg0.getNome());
	}
}