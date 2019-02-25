package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UtilDao {

	private DataSource dataSource;

	public UtilDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void dropDatabase() {

		Connection connection = dataSource.getConnection();
		try {
			String delete = "drop SEQUENCE if EXISTS Id;" + "DROP TABLE if exists lp CASCADE;"
					+ "DROP TABLE  if exists gruppo CASCADE;"
					+ "DROP TABLE  if exists copertina CASCADE;"
					+ "DROP TABLE  if exists photo CASCADE;";
					
			PreparedStatement statement = connection.prepareStatement(delete);

			statement.executeUpdate();
			System.out.println("Database dropped");

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

	public void createDatabase() {

		Connection connection = dataSource.getConnection();
		try {

			String create = "create SEQUENCE id;"
					+ "create table gruppo (id_gruppo bigint primary key, nome varchar(255));"
					+ "create table lp (id_lp bigint primary key, titolo varchar(255), anno bigint, genere varchar(255), id_gruppo bigint REFERENCES gruppo(id_gruppo));"
					+ "create table photo (id_gruppo bigint primary key, url_photo varchar);"
					+ "create table copertina (id_lp bigint primary key, url_copertina varchar);";
					;

			PreparedStatement statement = connection.prepareStatement(create);

			statement.executeUpdate();
			System.out.println("Database created");

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

	public void resetDatabase() {

		Connection connection = dataSource.getConnection();
		try {
			String delete = "delete FROM lp";
			PreparedStatement statement = connection.prepareStatement(delete);

			statement.executeUpdate();

			delete = "delete FROM lp";
			statement = connection.prepareStatement(delete);

			delete = "delete FROM gruppo";
			statement = connection.prepareStatement(delete);

			delete = "delete FROM copertina";
			statement = connection.prepareStatement(delete);

			delete = "delete FROM photo";
			statement = connection.prepareStatement(delete);

			statement.executeUpdate();
			System.out.println("Database resetted");
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
