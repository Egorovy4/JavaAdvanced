package javaAdvancedLesson10.dao;

import javaAdvancedLesson10.domain.User;
import javaAdvancedLesson10.shared.AbstractCRUD;

public interface UserDao extends AbstractCRUD<User> {
	User getUserByEmail(String email);
}
