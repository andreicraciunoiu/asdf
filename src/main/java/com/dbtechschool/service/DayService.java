package com.dbtechschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbtechschool.model.Day;
import com.dbtechschool.repository.DayRepository;

@Service
public class DayService {

	@Autowired
	private DayRepository dayRepository;

	public Day getById(Long id) {
		return dayRepository.findOne(id);
	}
}
