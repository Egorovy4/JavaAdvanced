package javaAdvancedLesson07.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaAdvancedLesson07.domain.User;
import javaAdvancedLesson07.domain.UserRole;
import javaAdvancedLesson07.service.UserService;
import javaAdvancedLesson07.service.impl.UserServiceImpl;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = UserServiceImpl.getUserService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String age = request.getParameter("age");

		if (!firstName.isEmpty() && !lastName.isEmpty() && !email.isEmpty() && !password.isEmpty() && !age.isEmpty()) {
			userService.create(
					new User(firstName, lastName, email, Integer.parseInt(age), UserRole.USER.toString(), password));
						
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("Success");
		} 
	}
}