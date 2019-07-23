package javaAdvancedLesson07.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import javaAdvancedLesson07.domain.User;
import javaAdvancedLesson07.dto.LoginedUser;
import javaAdvancedLesson07.service.UserService;
import javaAdvancedLesson07.service.impl.UserServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserService userService = UserServiceImpl.getUserService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User user = userService.getUserByEmail(email);

		if (user != null && user.getPassword().equals(password)) {
			LoginedUser loginedUser = new LoginedUser();
			loginedUser.userEmail = user.getEmail();
			loginedUser.destinationUrl = "cabinet.jsp";
			
			String json = new Gson().toJson(loginedUser);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		}
	}
}
