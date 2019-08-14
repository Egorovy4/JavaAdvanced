package javaAdvancedLesson08.dao;

import javaAdvancedLesson08.domain.User;
import javaAdvancedLesson08.shared.AbstractCRUD;

public interface UserDao extends AbstractCRUD<User> {
	User getUserByEmail(String email);
}
