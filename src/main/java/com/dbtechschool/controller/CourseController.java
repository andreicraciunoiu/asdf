package com.dbtechschool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dbtechschool.model.Course;
import com.dbtechschool.model.DatesContainer;
import com.dbtechschool.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	CourseService courseService;

	@RequestMapping(value = "/courses", method = RequestMethod.GET)
	public List<Course> listAllCourses() {
		return courseService.getAll();
	}
	
	@RequestMapping(value = "/course/{id}", method = RequestMethod.GET)
	public Course getById(@PathVariable(value = "id") Long id) {
		return courseService.getById(id);
	}
	
	@RequestMapping(value = "/course/dates/{id}", method = RequestMethod.GET)
	public List<String> getDatesById(@PathVariable(value = "id") Long id) {
		return courseService.getDatesByCourseId(id);
	}
	
	@RequestMapping(value = "/courses/user/{id}", method = RequestMethod.GET)
	public List<Course> getDaysByCourse(@PathVariable(value = "id") Long id) {
		return courseService.getCoursesByUserId(id);
	}
	
	@RequestMapping(value = "/courses/dates", method = RequestMethod.GET)
	public List<DatesContainer> getCoursesDates() {
		return courseService.getCoursesDates();
	}
	
	@RequestMapping(value = "/trainers/course/{id}", method = RequestMethod.GET)
	public List<String> getCourseTrainers(@PathVariable(value = "id") Long id) {
		return courseService.getTrainersByCourseId(id);
	}
	
	@RequestMapping(value = "/course/{id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable(value = "id") Long id) {
		courseService.deleteById(id);
	}

	@RequestMapping(value = "/clear/courses", method = RequestMethod.DELETE)
	public void deleteAll() {
		courseService.removeAll();
	}

	@RequestMapping(value = "/course", method = RequestMethod.POST)
	public void insertCourse(@RequestBody Course c) {
		courseService.insertCourse(c);
	}

	@RequestMapping(value = "/course/{id}", method = RequestMethod.PUT)
	public void updateCourse(@RequestBody Course c, @PathVariable(value = "id") Long id) {
		courseService.updateCourseById(c.getName(), c.getStart(), c.getEnd(), c.getTags(), c.getDescription(),
				c.getDifficulty(), id);
	}
}
