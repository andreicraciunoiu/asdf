package com.dbtechschool.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dbtechschool.model.Day;
import com.dbtechschool.service.DayService;

@RestController
public class DayController {

	@Autowired
	private DayService dayService;

	@RequestMapping(value = "/days", method = RequestMethod.GET)
	public List<Day> getAll() {
		return dayService.getAll();
	}

	@RequestMapping(value = "/day/{id}", method = RequestMethod.GET)
	public Day getById(@PathVariable(value = "id") Long id) {
		return dayService.getById(id);
	}
	
	@RequestMapping(value = "/days/course/{id}", method = RequestMethod.GET)
	public List<Day> getDaysByCourse(@PathVariable(value = "id") Long id) {
		return dayService.getDaysByCourseId(id);
	}

	@RequestMapping(value = "/day/{id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable(value = "id") Long id) {
		dayService.deleteById(id);
	}

	@RequestMapping(value = "/clear/days", method = RequestMethod.DELETE)
	public void deleteAll() {
		dayService.removeAll();
	}

	@RequestMapping(value = "/day", method = RequestMethod.POST)
	public void insertUser(@RequestBody Day d) {
		dayService.insertDay(d);
	}

	@RequestMapping(value = "/day/{id}", method = RequestMethod.PUT)
	public void updateDay(@RequestBody Day d, @PathVariable(value = "id") Long id) {
		dayService.updateDaybyId(d.getName(), d.getDate(), id);
	}
}