package com.dbtechschool.service;

import java.util.Date;
import java.util.List;

import com.dbtechschool.model.Day;
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

	public List<Section> findAllSections() {
		return ((List<Section>) sectionRepository.findAll());
	}

	public Section getById(Long id) {
		return sectionRepository.findOne(id);
	}

	public List<Section> getByDay(Long id) {
		return ((List<Section>) sectionRepository.getByDay(id));
	}

	public void deleteById(Long id) {
		sectionRepository.delete(id);
	}

	public void removeAll() {
		sectionRepository.deleteAll();
	}

	public void insertSection(Section newSection) {
		sectionRepository.save(newSection);
	}

	public void updateSectionById(String name, Date start, Date end, String room, String trainer, String description,
								  Double ratingAvg, Day day, Long id) {
		// TODO Auto-generated method stub
		sectionRepository.updateSectionbyId(name, start, end, room, trainer, description, ratingAvg, day, id);
	}
}
