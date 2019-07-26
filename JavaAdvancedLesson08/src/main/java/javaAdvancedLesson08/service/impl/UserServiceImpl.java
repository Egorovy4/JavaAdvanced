package javaAdvancedLesson08.service.impl;

import java.util.List;

import javaAdvancedLesson08.dao.UserDao;
import javaAdvancedLesson08.dao.impl.UserDaoImpl;
import javaAdvancedLesson08.domain.User;
import javaAdvancedLesson08.service.UserService;

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
