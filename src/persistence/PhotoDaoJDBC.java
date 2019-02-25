package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Photo;
import persistence.dao.PhotoDao;

public class PhotoDaoJDBC implements PhotoDao {

	private DataSource dataSource;

	public PhotoDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Photo photo) {
		if (photo.getId() == null) {
			throw new PersistenceException("Gruppo non memorizzato, un gruppo deve avere un Id");
		}
		Connection connection = this.dataSource.getConnection();

		try {
			String insert = "insert into photo(id_gruppo,url_photo) values (?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, photo.getId());
			statement.setString(2, photo.getUrl_photo());
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
	public Photo findByPrimaryKey(Long id) {
		Connection connection = this.dataSource.getConnection();
		Photo g = new Photo();
		try {
			PreparedStatement statement;
			String query = "select * from photo where id_gruppo = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				g.setId(result.getLong("id_gruppo"));
				g.setUrl_photo(result.getString("url_photo"));
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
	public List<Photo> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<Photo> copertine = new ArrayList<>();
		try {
			Photo g = new Photo();
			PreparedStatement statement;
			String query = "select * from photo";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				g = findByPrimaryKey(result.getLong("id_gruppo"));
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
	public void update(Photo copertina) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update copertina SET url_photo = ? WHERE id_gruppo = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, copertina.getUrl_photo());
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
	public void delete(Photo photo) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM photo WHERE id_gruppo = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setLong(1, photo.getId());
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
