package com.dbtechschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbtechschool.model.Section;
import com.dbtechschool.repository.SectionRepository;

@Service
public class SectionService {

	@Autowired
	SectionRepository sectionRepository;

	public List<Section> findAllCourses() {
		return ((List<Section>) sectionRepository.findAll());
	}
}
