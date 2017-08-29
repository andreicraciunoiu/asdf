package com.dbtechschool.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbtechschool.model.Course;
import com.dbtechschool.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getAll() {
		return ((List<Course>) courseRepository.findAll());
	}
	
	public Course getById(Long id) {
		return courseRepository.findOne(id);
	}
	
	public void deleteById(Long id) {
		courseRepository.delete(id);
	}
	
	public void removeAll() {
		courseRepository.deleteAll();
	}
	
	public void insertCourse(Course newCourse) {
		courseRepository.save(newCourse);
	}
	
	public void updateCourseById(String name, Date start, Date end, String tags, String description, char difficulty, Long id) {
		courseRepository.updateCourseById(name, start, end, tags, description, difficulty, id);
	}
}
