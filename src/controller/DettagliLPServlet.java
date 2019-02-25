package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Copertina;
import model.Gruppo;
import model.Lp;
import persistence.DatabaseManager;
import persistence.dao.CopertinaDao;
import persistence.dao.GruppoDao;
import persistence.dao.LpDao;

@WebServlet("/dettagliLPServlet")
public class DettagliLPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GruppoDao gDao = DatabaseManager.getInstance().getDaoFactory().getGruppoDAO();
		LpDao lpDao = DatabaseManager.getInstance().getDaoFactory().getLpDAO();
		Long id_lp = Long.parseLong(request.getParameter("id_lp"));
		Lp disco = lpDao.findByPrimaryKey(id_lp);
		Gruppo band = gDao.findByPrimaryKey(disco.getIdGruppo());
		CopertinaDao cDao = DatabaseManager.getInstance().getDaoFactory().getCopertinaDao();
		Copertina c = cDao.findByPrimaryKey(id_lp);
		request.setAttribute("gruppo", band);
		request.setAttribute("lp", disco);
		request.setAttribute("cop", c);
		RequestDispatcher rd = request.getRequestDispatcher("dettagliLp.jsp");
		rd.forward(request, response);
	}

}
