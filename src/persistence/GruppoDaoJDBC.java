package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Gruppo;
import persistence.dao.GruppoDao;

public class GruppoDaoJDBC implements GruppoDao {

	private DataSource dataSource;

	public GruppoDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Gruppo gruppo) {
		if (gruppo.getId() == null) {
			throw new PersistenceException("Gruppo non memorizzato, un gruppo deve avere un Id");
		}
		Connection connection = this.dataSource.getConnection();
		if (!findByName(gruppo.getNome())) {
			try {
				String insert = "insert into gruppo(id_gruppo, nome) values (?,?)";
				PreparedStatement statement = connection.prepareStatement(insert);
				statement.setLong(1, gruppo.getId());
				statement.setString(2, gruppo.getNome());
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
	}

	public boolean findByName(String nome) {
		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement statement;
			String query = "select * from gruppo where nome = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, nome);
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
	public Gruppo findByPrimaryKey(Long id) {
		Connection connection = this.dataSource.getConnection();
		Gruppo g = new Gruppo();
		try {
			PreparedStatement statement;
			String query = "select * from gruppo where id_gruppo = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				g.setId(result.getLong("id_gruppo"));
				g.setNome(result.getString("nome"));
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
	public List<Gruppo> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<Gruppo> gruppi = new ArrayList<>();
		Gruppo g = new Gruppo();
		PreparedStatement statement;
		try {
			String query = "select * from Gruppo";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				g = findByPrimaryKey(result.getLong("id_gruppo"));
				gruppi.add(g);
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
		Collections.sort(gruppi);
		return gruppi;
	}

	@Override
	public void update(Gruppo gruppo) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update Gruppo SET nome = ? WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, gruppo.getNome());
			statement.setLong(2, gruppo.getId());
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
	public void delete(Gruppo gruppo) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM Gruppo WHERE id = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setLong(1, gruppo.getId());
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
