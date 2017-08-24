package com.dbtechschool.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbtechschool.models.Section;
import com.dbtechschool.repositories.SectionRepository;

@Service
public class SectionService {

	@Autowired
	SectionRepository sectionRepository;

	public List<Section> findAllCourses() {
		return ((List<Section>) sectionRepository.findAll());
	}
}
