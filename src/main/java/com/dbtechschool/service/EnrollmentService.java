package com.dbtechschool.service;

import com.dbtechschool.model.Enrollment;
import com.dbtechschool.repository.EnrollmentRepository;

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

	public void insertEnrollment(Long id_c, Long id_u) {
		enrollmentRepository.insertEnrollment(id_c, id_u);
	}
}
