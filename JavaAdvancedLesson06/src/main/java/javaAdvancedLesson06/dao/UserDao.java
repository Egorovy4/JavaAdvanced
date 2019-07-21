package javaAdvancedLesson06.dao;

import javaAdvancedLesson06.domain.User;
import javaAdvancedLesson06.shared.AbstractCRUD;

public interface UserDao extends AbstractCRUD<User> {
	User getUserByEmail(String email);
}
