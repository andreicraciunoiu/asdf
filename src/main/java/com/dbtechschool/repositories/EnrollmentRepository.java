package com.dbtechschool.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dbtechschool.models.Enrollment;

@Repository
public interface EnrollmentRepository extends CrudRepository<Enrollment, Long> {

}
