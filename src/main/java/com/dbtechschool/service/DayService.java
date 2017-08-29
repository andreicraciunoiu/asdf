package com.dbtechschool.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbtechschool.model.Course;
import com.dbtechschool.model.DatesContainer;
import com.dbtechschool.model.Day;
import com.dbtechschool.repository.DayRepository;

@Service
public class DayService {

	@Autowired
	private DayRepository dayRepository;
	
	public Day getById(Long id) {
		return dayRepository.findOne(id);
	}
	
	public List<Day> getAll() {
		List<Day> days = new ArrayList<>();
		dayRepository.findAll().forEach(days::add);
		return days;
	}
	
	public void deleteById(Long id) {
		dayRepository.delete(id);
	}
	
	public void removeAll() {
		dayRepository.deleteAll();
	}
	
	public void insertDay(Day newDay) {
		dayRepository.save(newDay);
	}

	public List<Day> getDaysByCourseId(Long id) {
		return dayRepository.getDaysByCourseId(id);
	}

	public void updateDaybyId(String name, Date date, Long id) {
		dayRepository.updateDaybyId(name, date, id);	
	}

	public List<DatesContainer> getDaysDates() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		List<DatesContainer> dates = new ArrayList<>();
		List<Day> days = new ArrayList<>();
		dayRepository.findAll().forEach(days::add);
		for(int i=0; i<days.size(); i++) {
			DatesContainer d = new DatesContainer(formatter.format(days.get(i).getDate()), formatter.format(days.get(i).getDate()));
			dates.add(d);
		}
		return dates;
	}

	public String getDateByDayId(Long id) {
		Day aux = dayRepository.findOne(id);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(aux.getDate());
	}
}
