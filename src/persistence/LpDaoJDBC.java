package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Lp;
import persistence.dao.LpDao;

public class LpDaoJDBC implements LpDao {

	private DataSource dataSource;
	
	public LpDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Lp lp) {

		if (lp.getIdGruppo() == null) {
			throw new PersistenceException("Lp Non memorizzato : un Lp deve avere un Gruppo");
		}
		Connection connection = dataSource.getConnection();
		try {
			String insert = "insert into lp (id_lp, titolo, anno, genere, id_gruppo) values (?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, lp.getId());
			statement.setString(2, lp.getTitolo());
			statement.setInt(3, lp.getAnno());
			statement.setString(4, lp.getGenere());
			statement.setLong(5, lp.getIdGruppo());
			statement.executeUpdate();
			this.update(lp);
		}catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				}catch (SQLException excep) {
					throw new PersistenceException(e.getMessage());
				}
			}
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}

	}

	public boolean findByName(String titolo) {
		Connection connection = dataSource.getConnection();
		try {
			PreparedStatement statement;
			String query = "select * from lp where titolo = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, titolo);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				return true;
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return false;
	}

	@Override
	public Lp findByPrimaryKey(Long id) {

		Lp lp = new Lp();
		Connection connection = dataSource.getConnection();
		try {
			PreparedStatement statement;
			String query = "select * from lp where id_lp = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				lp.setId(result.getLong("id_lp"));
				lp.setTitolo(result.getString("titolo"));
				lp.setAnno(result.getInt("anno"));
				lp.setGenere(result.getString("genere"));
				lp.setIdGruppo(result.getLong("id_gruppo"));
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return lp;
	}

	@Override
	public List<Lp> findAll() {
		List<Lp> lista = new ArrayList<>();
		Connection connection = dataSource.getConnection();
		try {
			
			PreparedStatement statement;
			String query = "select * from Lp";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Lp lp = new Lp();
				lp.setId(result.getLong("id_lp"));
				lp.setTitolo(result.getString("titolo"));
				lp.setAnno(result.getInt("anno"));
				lp.setIdGruppo(result.getLong("id_gruppo"));
				lp.setGenere(result.getString("genere"));
				lista.add(lp);
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		Collections.sort(lista);
		return lista;
	}

	public List<Lp> findByBand(Long id) {
		List<Lp> lista = new ArrayList<>();
		Connection connection = dataSource.getConnection();
		try {
			PreparedStatement statement;
			String query = "select * from Lp where id_gruppo = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Lp lp = new Lp();
				lp.setId(result.getLong("id_lp"));
				lp.setTitolo(result.getString("titolo"));
				lp.setAnno(result.getInt("anno"));
				lp.setIdGruppo(result.getLong("id_gruppo"));
				lp.setGenere(result.getString("genere"));
				lista.add(lp);
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		Collections.sort(lista);
		return lista;
	}

	@Override
	public void update(Lp lp) {
		Connection connection = dataSource.getConnection();
		try {
			String update = "update lp SET titolo = ?, anno = ?, genere = ?, id_gruppo = ? WHERE id_lp = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, lp.getTitolo());
			statement.setInt(2, lp.getAnno());
			statement.setString(3, lp.getGenere());
			statement.setLong(4, lp.getIdGruppo());
			statement.setLong(5, lp.getId());

			statement.executeUpdate();
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException excep) {
					throw new PersistenceException(e.getMessage());
				}
			}
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}

	@Override
	public void delete(Lp lp) {
		Connection connection = dataSource.getConnection();
		try {
			String delete = "delete FROM lp WHERE id_lp = ? ";
			System.out.println(lp.getId());
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setLong(1, lp.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}

}
