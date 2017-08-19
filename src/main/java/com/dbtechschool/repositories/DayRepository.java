package com.dbtechschool.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dbtechschool.models.Day;

@Repository
public interface DayRepository extends CrudRepository<Day, Long> {
}
