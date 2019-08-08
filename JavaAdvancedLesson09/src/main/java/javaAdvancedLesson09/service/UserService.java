package javaAdvancedLesson09.service;

import javaAdvancedLesson09.domain.User;
import javaAdvancedLesson09.shared.AbstractCRUD;

public interface UserService extends AbstractCRUD<User> {
	User getUserByEmail(String email);
}
