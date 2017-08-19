package com.dbtechschool.controllers;

import com.dbtechschool.models.Enrollment;
import com.dbtechschool.services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EnrollmentController {

	@Autowired
	private EnrollmentService courseService;

	@RequestMapping("/enrollment")
	public List<Enrollment> listAllCourses() {
		return courseService.findAllEnrollments();
	}
}
