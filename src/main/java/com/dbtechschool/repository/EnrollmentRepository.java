package com.dbtechschool.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dbtechschool.model.Enrollment;

@Repository
public interface EnrollmentRepository extends CrudRepository<Enrollment, Long> {

}
