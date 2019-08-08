package javaAdvancedLesson09.dao;

import javaAdvancedLesson09.domain.User;
import javaAdvancedLesson09.shared.AbstractCRUD;

public interface UserDao extends AbstractCRUD<User> {
	User getUserByEmail(String email);
}
