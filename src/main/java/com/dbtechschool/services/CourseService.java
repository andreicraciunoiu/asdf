package com.dbtechschool.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbtechschool.models.Course;
import com.dbtechschool.repositories.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public List<Course> findAllCourses() {
		return ((List<Course>) courseRepository.findAll());
	}
}
