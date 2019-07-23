package javaAdvancedLesson07.dao;

import javaAdvancedLesson07.domain.User;
import javaAdvancedLesson07.shared.AbstractCRUD;

public interface UserDao extends AbstractCRUD<User> {
	User getUserByEmail(String email);
}
