package com.dbtechschool.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dbtechschool.model.DatesContainer;
import com.dbtechschool.model.Day;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbtechschool.model.Section;
import com.dbtechschool.repository.SectionRepository;

@Service
public class SectionService {

	@Autowired
	SectionRepository sectionRepository;

	public List<Section> findAllSections() {
		List<Section> sections = new ArrayList<>();
		sectionRepository.findAll().forEach(sections::add);
		return sections;
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
		sectionRepository.updateSectionbyId(name, start, end, room, trainer, description, ratingAvg, day, id);
	}

	public List<String> getHoursBySectionId(Long id) {
		Section aux = sectionRepository.findOne(id);
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		List<String> hours = new ArrayList<>();
		hours.add(formatter.format(aux.getStart()));
		hours.add(formatter.format(aux.getEnd()));
		return hours;
	}

	public List<DatesContainer> getSectionsHours() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		List<DatesContainer> dates = new ArrayList<>();
		List<Section> sections = new ArrayList<>();
		sectionRepository.findAll().forEach(sections::add);
		for(int i=0; i<=sections.size(); i++) {
			DatesContainer d = new DatesContainer(formatter.format(sections.get(i).getStart()), formatter.format(sections.get(i).getEnd()));
			dates.add(d);
		}
		return dates;
	}
}
