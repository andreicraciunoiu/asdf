package com.dbtechschool.services;

import com.dbtechschool.models.Enrollment;
import com.dbtechschool.repositories.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {

	@Autowired
	private EnrollmentRepository enrollmentRepository;

	public List<Enrollment> findAllEnrollments() {
		return ((List<Enrollment>) enrollmentRepository.findAll());
	}
}
