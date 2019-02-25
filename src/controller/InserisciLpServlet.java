package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.DatabaseManager;
import persistence.dao.CopertinaDao;
import persistence.dao.GruppoDao;
import persistence.dao.LpDao;
import model.Copertina;
import model.Gruppo;
import model.Lp;

public class InserisciLpServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		LpDao lpDao = DatabaseManager.getInstance().getDaoFactory().getLpDAO();
		String titolo = req.getParameter("titolo");
		int anno = Integer.parseInt(req.getParameter("anno"));
		String genere = req.getParameter("genere");
		Long id_gruppo = Long.parseLong(req.getParameter("id_gruppo"));
		GruppoDao gDao = DatabaseManager.getInstance().getDaoFactory().getGruppoDAO();
		Gruppo g = gDao.findByPrimaryKey(id_gruppo);
		String url = req.getParameter("url_copertina");
		if (!lpDao.findByName(titolo)) {
			Lp new_lp = new Lp(persistence.DataSource.getInstance().getConnection(), titolo, anno, genere, id_gruppo);
			Copertina c = new Copertina(new_lp.getId());
			CopertinaDao cDao =  DatabaseManager.getInstance().getDaoFactory().getCopertinaDao();
			c.setCopertina(url);
			lpDao.save(new_lp);
			cDao.save(c);
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
		}
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GruppoDao gDao = DatabaseManager.getInstance().getDaoFactory().getGruppoDAO();
		List<Gruppo> bands = gDao.findAll();
		req.setAttribute("gruppi", bands);
		RequestDispatcher rd = req.getRequestDispatcher("gestioneLp/inserisciLp.jsp");
		rd.forward(req, resp);
	}
}
