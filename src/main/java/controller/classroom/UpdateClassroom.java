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
 * Servlet implementation class UpdateClassroom
 */
public class UpdateClassroom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection connection = ConnectionDatabase.getConnection();
		ClassroomDao classroomDao = new ClassroomDaoImpl(connection);
		
		Classroom classroom = classroomDao.get(Integer.parseInt(request.getParameter("id")));
		
		request.setAttribute("classroom", classroom);
		
		this.getServletContext().getRequestDispatcher("/vue/classroom/UpdateClassroom.jsp").forward( request, response );
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
