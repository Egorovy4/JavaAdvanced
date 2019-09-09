package javaAdvancedLesson19.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javaAdvancedLesson19.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

}
