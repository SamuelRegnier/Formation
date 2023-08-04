package controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import dao.UserDao;
import dao.UserDaoImpl;
import database.ConnectionDatabase;
import entity.User;

/**
 * Servlet implementation class SuppressionUserServlet
 */
@WebServlet("/user/suppression")
public class SuppressionUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuppressionUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = ConnectionDatabase.getConnection();
		UserDao userDao = new UserDaoImpl(connection);
		
		User user = userDao.get(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("user", user);
		
		userDao.delete(user);
		
		this.getServletContext().getRequestDispatcher("/vue/user/SuppressionUser.jsp").forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
