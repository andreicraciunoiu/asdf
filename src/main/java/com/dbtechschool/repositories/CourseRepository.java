package com.dbtechschool.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dbtechschool.models.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {
}
