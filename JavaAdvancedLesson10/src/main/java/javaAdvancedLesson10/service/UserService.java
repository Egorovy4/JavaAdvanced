package javaAdvancedLesson10.service;

import javaAdvancedLesson10.domain.User;
import javaAdvancedLesson10.shared.AbstractCRUD;

public interface UserService extends AbstractCRUD<User> {
	User getUserByEmail(String email);
}
