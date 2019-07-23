package javaAdvancedLesson07.service.impl;

import java.util.List;

import javaAdvancedLesson07.dao.UserDao;
import javaAdvancedLesson07.dao.impl.UserDaoImpl;
import javaAdvancedLesson07.domain.User;
import javaAdvancedLesson07.service.UserService;

public class UserServiceImpl implements UserService {
	private static UserService userServiceImpl;
	private UserDao userDao;

	private UserServiceImpl() {
		userDao = new UserDaoImpl();
	}

	public static UserService getUserService() {
		if (userServiceImpl == null) {
			userServiceImpl = new UserServiceImpl();
		}

		return userServiceImpl;
	}

	@Override
	public User create(User user) {
		return userDao.create(user);
	}

	@Override
	public User read(Integer id) {
		return userDao.read(id);
	}

	@Override
	public User update(User user) {
		return userDao.update(user);
	}

	@Override
	public void delete(Integer id) {
		userDao.delete(id);
	}

	@Override
	public List<User> readAll() {
		return userDao.readAll();
	}

	@Override
	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}
}
