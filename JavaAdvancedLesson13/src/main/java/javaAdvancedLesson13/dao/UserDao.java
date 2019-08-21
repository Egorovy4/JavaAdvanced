package javaAdvancedLesson13.dao;

import javaAdvancedLesson13.domain.User;
import javaAdvancedLesson13.shared.AbstractCRUD;

public interface UserDao extends AbstractCRUD<User> {
	User getUserByEmail(String email);
}
