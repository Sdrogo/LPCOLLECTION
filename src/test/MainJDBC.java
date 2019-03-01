package test;

import model.*;
import persistence.*;
import persistence.dao.*;

public class MainJDBC {

	public static void main(String args[]) {

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		LpDao lpDao = factory.getLpDAO();
		GruppoDao gruppoDao = factory.getGruppoDAO();
		CopertinaDao cDato = factory.getCopertinaDao();
		PhotoDao photoDao = factory.getPhotoDao();
		UtilDao util = factory.getUtilDAO();
		 //util.dropDatabase();
		 //util.createDatabase();
		 //util.resetDatabase();
		 Gruppo g = gruppoDao.findByPrimaryKey(Long.parseLong("5517"));
		 gruppoDao.delete(g);
	}
}