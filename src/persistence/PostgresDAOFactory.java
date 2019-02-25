package persistence;

import persistence.dao.*;

public class PostgresDAOFactory extends DAOFactory {

	private static DataSource dataSource;

	static {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			// questi vanno messi in file di configurazione!!!
//			dataSource=new DataSource("jdbc:postgresql://52.39.164.176:5432/xx","xx","p@xx");
			dataSource = DataSource.getInstance();
		} catch (Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n" + e);
			e.printStackTrace();
		}
	}

	@Override
	public LpDao getLpDAO() {
		return new LpDaoJDBC(dataSource);
	}

	@Override
	public GruppoDao getGruppoDAO() {
		// TODO Auto-generated method stub
		return new GruppoDaoJDBC(dataSource);
	}


	@Override
	public CopertinaDao getCopertinaDao() {
		// TODO Auto-generated method stub
		return new CopertinaDaoJDBC(dataSource); 
	}

	@Override
	public PhotoDao getPhotoDao() {
		// TODO Auto-generated method stub
		return new PhotoDaoJDBC(dataSource);
	}

	@Override
	public UtilDao getUtilDAO() {
		return new UtilDao(dataSource);
	}

}