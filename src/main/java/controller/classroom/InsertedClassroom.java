package controller.classroom;

import java.io.IOException;
import java.sql.Connection;

import dao.ClassroomDao;
import dao.ClassroomDaoImpl;
import database.ConnectionDatabase;
import entity.Classroom;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertedClassroom
 */
public class InsertedClassroom extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    Connection connection = ConnectionDatabase.getConnection();
		ClassroomDao classroomDao = new ClassroomDaoImpl(connection);
		boolean isInserted = Boolean.valueOf(request.getParameter("inserted"));
		Integer id = 0;
		if (!isInserted) {
			id = Integer.parseInt(request.getParameter("id"));
		}
		String nom = request.getParameter("nom");
		String nbPlaces = request.getParameter("nbPlaces");
		Integer capaciteInt = Integer.parseInt(nbPlaces);
		String statut = request.getParameter("statut");
		if (isInserted) {
			classroomDao.add(new Classroom(nom,capaciteInt,statut));
		} else {
			classroomDao.update(new Classroom(id,nom,capaciteInt,statut));
		}
		this.getServletContext().getRequestDispatcher("/vue/classroom/InsertedClassroom.jsp").forward( request, response );
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}
}
