package com.dbtechschool.controller;

import com.dbtechschool.model.Enrollment;
import com.dbtechschool.service.EnrollmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EnrollmentController {

	@Autowired
	private EnrollmentService enrolService;

	@RequestMapping("/enrollment")
	public List<Enrollment> listAllCourses() {
		return enrolService.findAllEnrollments();
	}
	
	@RequestMapping(value = "/enrol/{id_c}/{id_u}", method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public @ResponseBody void enrol(@PathVariable(value = "id_c") Long id_c, @PathVariable(value = "id_u") Long id_u) {
		enrolService.insertEnrollment(id_c, id_u);
	}
}
