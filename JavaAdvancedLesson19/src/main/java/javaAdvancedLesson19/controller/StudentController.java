package javaAdvancedLesson19.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javaAdvancedLesson19.domain.Student;
import javaAdvancedLesson19.dto.StudentResponse;
import javaAdvancedLesson19.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/uploadStudent")
	public StudentResponse uploadStudent(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("age") Integer age,
			@RequestParam("file") MultipartFile file) throws NumberFormatException, IOException {
		Student student = studentService.saveStudent(firstName, lastName, age, file);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadStudent/")
				.path(student.getId()).toUriString();

		return new StudentResponse(student.getFirstName(), student.getLastName(), student.getAge(), file.getName(),
				file.getContentType(), fileDownloadUri, file.getSize());
	}

	@GetMapping("/downloadStudent/{id}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String id) throws FileNotFoundException {
		Student student = studentService.getStudentById(id);
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(student.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + student.getFileName() + "\"")
				.body(new ByteArrayResource(student.getData()));
	}
}
