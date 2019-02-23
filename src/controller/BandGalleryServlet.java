package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Gruppo;
import persistence.DatabaseManager;
import persistence.dao.GruppoDao;


public class BandGalleryServlet extends HttpServlet{
	

	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{			
		GruppoDao gDao = DatabaseManager.getInstance().getDaoFactory().getGruppoDAO();
		List<Gruppo> bands = gDao.findAll();
		request.setAttribute("gruppi", bands);
		RequestDispatcher rd = request.getRequestDispatcher
				("gallery/galleryGruppi.jsp");
		rd.forward(request, response);
	}
	
}
