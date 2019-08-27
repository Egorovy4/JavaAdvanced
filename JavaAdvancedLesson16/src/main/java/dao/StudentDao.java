package dao;

import java.util.List;

import javaAdvancedLesson16.Student;

public interface StudentDao {
	void create(Student student);

	Student readById(int id);

	List<Student> readAll();

	void update(Student student);

	void delete(int id);
}
