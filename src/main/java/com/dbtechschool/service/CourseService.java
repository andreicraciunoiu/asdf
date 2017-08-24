package com.dbtechschool.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbtechschool.models.Course;
import com.dbtechschool.repositories.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getAll() {
		return ((List<Course>) courseRepository.findAll());
	}
	
	public Course getById(int id) {
		return courseRepository.findOne(id);
	}
	
	public void deleteById(int id) {
		courseRepository.delete(id);
	}
	
	public void removeAll() {
		courseRepository.deleteAll();
	}
	
	public void insertCourse(Course newCourse) {
		courseRepository.save(newCourse);
	}
	
	public void updateCourseById(String name, Date start, Date end, String tags, String description, char difficulty, int id) {
		courseRepository.updateCourseById(name, start, end, tags, description, difficulty, id);
	}
}
