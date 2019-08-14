package javaAdvancedLesson06.service;

import javaAdvancedLesson06.domain.User;
import javaAdvancedLesson06.shared.AbstractCRUD;

public interface UserService extends AbstractCRUD<User> {
	User getUserByEmail(String email);
}
