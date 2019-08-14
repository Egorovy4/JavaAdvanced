package javaAdvancedLesson05.service.impl;

import java.util.List;

import javaAdvancedLesson05.dao.UserDao;
import javaAdvancedLesson05.dao.impl.UserDaoImpl;
import javaAdvancedLesson05.domain.User;
import javaAdvancedLesson05.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	
	public UserServiceImpl() {
		userDao = new UserDaoImpl();
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
}
