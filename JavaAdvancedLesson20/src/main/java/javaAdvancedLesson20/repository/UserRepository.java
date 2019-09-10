package javaAdvancedLesson20.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javaAdvancedLesson20.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	public User findByUserName(String username);
}