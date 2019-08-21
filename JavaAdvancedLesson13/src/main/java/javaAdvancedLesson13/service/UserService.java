package javaAdvancedLesson13.service;

import javaAdvancedLesson13.domain.User;
import javaAdvancedLesson13.shared.AbstractCRUD;

public interface UserService extends AbstractCRUD<User> {
	User getUserByEmail(String email);
}
