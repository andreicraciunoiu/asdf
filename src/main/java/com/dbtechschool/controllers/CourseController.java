package com.dbtechschool.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbtechschool.models.Course;
import com.dbtechschool.services.CourseService;

@RestController
public class CourseController {

	@Autowired
	CourseService courseService;

	@RequestMapping("/courses")
	public List<Course> listAllCourses() {
		return courseService.findAllCourses();
	}
}
