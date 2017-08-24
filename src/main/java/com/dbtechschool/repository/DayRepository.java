package com.dbtechschool.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dbtechschool.model.Day;

@Repository
public interface DayRepository extends CrudRepository<Day, Long> {
}
