package controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import database.ConnectionDatabase;
import entity.User;
import dao.UserDao;
import dao.UserDaoImpl;
/**
 * Servlet implementation class ModificationUserServlet
 */
@WebServlet("/user/modification")
public class ModificationUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection = ConnectionDatabase.getConnection();
	UserDao userDao = new UserDaoImpl(connection);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificationUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = userDao.get(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("user", user);
		
		this.getServletContext().getRequestDispatcher("/vue/user/ModificationUser.jsp").forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User(Integer.parseInt(request.getParameter("id")), request.getParameter("name"), request.getParameter("firstname"), java.sql.Date.valueOf(request.getParameter("birthday")), request.getParameter("adress"), request.getParameter("mail"), request.getParameter("phone"), request.getParameter("statut"));
		userDao.update(user);
		
		List<User> users = new ArrayList<>();
		users = userDao.getAll();
		request.setAttribute("users", users);
		
		this.getServletContext().getRequestDispatcher("/vue/user/AffichageUser.jsp").forward(request, response);
	}

}
