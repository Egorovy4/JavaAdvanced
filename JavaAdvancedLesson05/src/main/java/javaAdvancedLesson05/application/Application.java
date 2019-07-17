package javaAdvancedLesson05.application;

import javaAdvancedLesson05.domain.User;
import javaAdvancedLesson05.service.UserService;
import javaAdvancedLesson05.service.impl.UserServiceImpl;

public class Application {
	public static void main(String[] args) {
		UserService userService = new UserServiceImpl();
		
		userService.cteate(new User("Igor", "Iwanyshyn", "iwanyshyn@gmail.com", 22, "user"));
		System.out.println(userService.read(1));
		userService.update(new User(1, "Igor", "Iwanyshyn", "iwanyshyn@gmail.com", 22, "admin"));
		userService.delete(1);
		System.out.println(userService.readAll());
	}
}
