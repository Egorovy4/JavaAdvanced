package javaAdvancedLesson19.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javaAdvancedLesson19.dao.StudentRepository;
import javaAdvancedLesson19.domain.Student;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student saveStudent(String firstName, String lastName, Integer age, MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		Student student = null;

		if (!fileName.contains("..")) {
			student = new Student(firstName, lastName, age, fileName, file.getContentType(), file.getBytes());
		}

		return studentRepository.save(student);
	}

	public Student getStudentById(String id) throws FileNotFoundException {
		return studentRepository.findById(id)
				.orElseThrow(() -> new FileNotFoundException("File not fount with id = " + id));
	}
}
