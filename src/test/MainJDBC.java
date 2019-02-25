package test;


import model.*;
import persistence.*;
import persistence.dao.*;

public class MainJDBC {

	public static void main(String args[]) {

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		UtilDao util = factory.getUtilDAO();
		// util.dropDatabase();
		// util.createDatabase();
		LpDao lpDao = DatabaseManager.getInstance().getDaoFactory().getLpDAO();
		Lp l = lpDao.findByPrimaryKey(Long.parseLong(""));
		lpDao.delete(l);
	}
}