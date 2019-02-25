package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Gruppo;
import model.Lp;
import persistence.DatabaseManager;
import persistence.dao.GruppoDao;
import persistence.dao.LpDao;

@WebServlet("/LpGalleryServlet")
public class LpGalleryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LpGalleryServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GruppoDao gDao = DatabaseManager.getInstance().getDaoFactory().getGruppoDAO();
		List<Gruppo> bands = gDao.findAll();
		request.setAttribute("lista_gruppi", bands);
		RequestDispatcher rd = request.getRequestDispatcher("gallery/galleryLp.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
