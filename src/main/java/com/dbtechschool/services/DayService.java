package com.dbtechschool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbtechschool.models.Day;
import com.dbtechschool.repositories.DayRepository;

@Service
public class DayService {

	@Autowired
	private DayRepository dayRepository;
	
	public Day getById(Long id) {
		return dayRepository.findOne(id);
	}
}
