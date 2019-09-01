package javaAdvancedLesson17;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javaAdvancedLesson17.domain.University;
import javaAdvancedLesson17.service.UniversityService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

		UniversityService universityService = ctx.getBean(UniversityService.class);

		University university = new University();
		university.setName("PNU");
		university.setLevelOfAccreditation(3);
		university.setQuantityOfInstitutes(40);
		university.setQuantityOfStudents(20000);
		university.setAddress("Ivano-Frankivsk");
		
		// save university to DB
		universityService.create(university);

		// read from DB
		System.out.println(universityService.readById((long) 1));
		
		// update university from DB
		University forUpdate = universityService.readById((long) 1);
		forUpdate.setQuantityOfStudents(10000);
		universityService.update(forUpdate);

		// delete university from DB
		universityService.deleteById((long) 1);

		// readAll from DB
		universityService.readAll().stream().forEach(System.out::println);
	}
}
