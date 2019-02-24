package test;
import java.util.List;

import model.Lp;
import persistence.*;
import persistence.dao.LpDao;

public class MainJDBC{
	
	public static void main (String args[]) {
		
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		UtilDao util = factory.getUtilDAO();
		//util.dropDatabase();
		//util.createDatabase();
		LpDao lpDao = DatabaseManager.getInstance().getDaoFactory().getLpDAO();
		List<Lp> lps = lpDao.findAll();
		System.out.println("ciao");
		for(Lp l:lps) {
			System.out.println(l.getGenere());
			if(l.getGenere().equals("Progerssive")) {
				System.out.println("entrato");
				l.setGenere("Progressive");
				lpDao.update(l);
			}
			
		}
		
	}
	
}