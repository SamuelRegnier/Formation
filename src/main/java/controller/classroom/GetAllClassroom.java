package controller.classroom;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import dao.ClassroomDao;
import dao.ClassroomDaoImpl;
import database.ConnectionDatabase;
import entity.Classroom;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetAllClassrooms
 */
public class GetAllClassroom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	Connection connection = ConnectionDatabase.getConnection();
    	ClassroomDao classroomDao = new ClassroomDaoImpl(connection);
		
    	List<Classroom> listClassroom = classroomDao.getAll();
    	request.setAttribute("listClassroom", listClassroom);
    	this.getServletContext().getRequestDispatcher("/vue/classroom/ViewAllClassroom.jsp").forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
