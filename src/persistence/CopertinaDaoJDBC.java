package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Copertina;
import persistence.dao.CopertinaDao;

public class CopertinaDaoJDBC implements CopertinaDao {

	private DataSource dataSource;

	public CopertinaDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Copertina copertina) {
		if (copertina.getId() == null) {
			throw new PersistenceException("Gruppo non memorizzato, un gruppo deve avere un Id");
		}
		Connection connection = this.dataSource.getConnection();

		try {
			String insert = "insert into copertina(id_lp,url_copertina) values (?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, copertina.getId());
			statement.setString(2, copertina.getCopertina());
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
	public Copertina findByPrimaryKey(Long id) {
		Connection connection = this.dataSource.getConnection();
		Copertina g = new Copertina();
		try {
			PreparedStatement statement;
			String query = "select * from copertina where id_lp = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				g.setId(result.getLong("id_lp"));
				g.setCopertina(result.getString("url_copertina"));
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
		return g;
	}

	@Override
	public List<Copertina> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<Copertina> copertine = new ArrayList<>();
		try {
			
			PreparedStatement statement;
			String query = "select * from copertina";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Copertina g = new Copertina();
				g.setId(result.getLong("id_lp"));
				g.setCopertina(result.getString("url_copertina"));
				copertine.add(g);
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
		// TODO Auto-generated method stub
		return copertine;
	}

	@Override
	public void update(Copertina copertina) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update copertina SET url_copertina = ? WHERE id_lp = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, copertina.getCopertina());
			statement.setLong(2, copertina.getId());
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
	public void delete(Copertina copertina) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM copertina WHERE id_lp = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setLong(1, copertina.getId());
			statement.executeUpdate();
			connection.commit();
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
