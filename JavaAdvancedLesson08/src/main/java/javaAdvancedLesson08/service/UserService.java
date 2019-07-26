package javaAdvancedLesson08.service;

import javaAdvancedLesson08.domain.User;
import javaAdvancedLesson08.shared.AbstractCRUD;

public interface UserService extends AbstractCRUD<User> {
	User getUserByEmail(String email);
}
