package javaAdvancedLesson07.service;

import javaAdvancedLesson07.domain.User;
import javaAdvancedLesson07.shared.AbstractCRUD;

public interface UserService extends AbstractCRUD<User> {
	User getUserByEmail(String email);
}
