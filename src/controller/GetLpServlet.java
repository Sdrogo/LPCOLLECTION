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

@WebServlet("/GetLpServlet")
public class GetLpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetLpServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("lpGruppo.jsp");
		Long id_gruppo = Long.parseLong(request.getParameter("id_gruppo"));
		LpDao lpDao = DatabaseManager.getInstance().getDaoFactory().getLpDAO();
		GruppoDao gDao = DatabaseManager.getInstance().getDaoFactory().getGruppoDAO();
		Gruppo g = gDao.findByPrimaryKey(id_gruppo);
		List<Lp> lista = lpDao.findByBand(id_gruppo);
		request.setAttribute("lista_lp", lista);
		request.setAttribute("gruppo", g);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
