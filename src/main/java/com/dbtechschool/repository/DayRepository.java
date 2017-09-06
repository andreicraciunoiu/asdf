package com.dbtechschool.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dbtechschool.model.Day;

@Repository
public interface DayRepository extends CrudRepository<Day, Long> {
	
	List<Day> getDaysByCourseId(Long id);
	
	@Modifying
	@Transactional
	@Query("update Day d set d.name = ?1, d.date = ?2 where d.id = ?3")
	int updateDaybyId(String name, String date, Long id);
}
