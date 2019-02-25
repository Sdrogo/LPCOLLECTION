package persistence;

import persistence.dao.*;

public abstract class DAOFactory {

	public static final int MYSQL = 1;

	public static final int POSTGRESQL = 2;

	public static DAOFactory getDAOFactory(int fac) {
		switch (fac) {
		case MYSQL:
			return null;
		case POSTGRESQL:
			return new PostgresDAOFactory();
		default:
			return null;
		}
	}

	public abstract LpDao getLpDAO();

	public abstract GruppoDao getGruppoDAO();
	
	public abstract CopertinaDao getCopertinaDao();
	
	public abstract PhotoDao getPhotoDao();

	public abstract persistence.UtilDao getUtilDAO();
	
}
