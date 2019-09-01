package javaAdvancedLesson17.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaAdvancedLesson17.dao.UniversityRepository;
import javaAdvancedLesson17.domain.University;
import javaAdvancedLesson17.service.UniversityService;

@Service
public class UniversityServiceImpl implements UniversityService {

	@Autowired
	private UniversityRepository universityRepository;

	@Override
	public University create(University university) {
		return universityRepository.saveAndFlush(university);
	}

	@Override
	public University readById(Long id) {
		return universityRepository.getOne(id);
	}

	@Override
	public University update(University university) {
		return universityRepository.save(university);
	}

	@Override
	public void deleteById(Long id) {
		universityRepository.deleteById(id);
	}

	@Override
	public List<University> readAll() {
		return universityRepository.findAll();
	}
}
