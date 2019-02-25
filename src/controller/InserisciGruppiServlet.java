package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Gruppo;
import persistence.DatabaseManager;
import persistence.dao.GruppoDao;

public class InserisciGruppiServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String url_photo = req.getParameter("url_photo");
		GruppoDao gDao = DatabaseManager.getInstance().getDaoFactory().getGruppoDAO();
		if (nome != "" && nome != null && !gDao.findByName(nome)) {
			Gruppo new_gruppo = new Gruppo(persistence.DataSource.getInstance().getConnection());
			new_gruppo.setNome(nome);
			new_gruppo.setUrl_photo(url_photo);
			gDao.save(new_gruppo);
		}
		RequestDispatcher rd = req.getRequestDispatcher("gestioneLp/inserisciGruppo.jsp");
		rd.forward(req, resp);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("gestioneLp/inserisciGruppo.jsp");
		rd.forward(request, response);
	}

}
