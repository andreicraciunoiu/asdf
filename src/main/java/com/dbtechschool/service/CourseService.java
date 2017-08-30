package com.dbtechschool.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbtechschool.model.Course;
import com.dbtechschool.model.DatesContainer;
import com.dbtechschool.model.User;
import com.dbtechschool.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getAll() {
		return courseRepository.getCourses();
	}
	
	public Course getById(Long id) {
		return courseRepository.findOne(id);
	}
	
	public void deleteById(Long id) {
		courseRepository.delete(id);
	}
	
	public void removeAll() {
		courseRepository.deleteAll();
	}
	
	public void insertCourse(Course newCourse) {
		courseRepository.save(newCourse);
	}
	
	public void updateCourseById(String name, Date start, Date end, String tags, String description, char difficulty, Long id) {
		courseRepository.updateCourseById(name, start, end, tags, description, difficulty, id);
	}

	public List<Course> getCoursesByUserId(Long id) {
		// TODO Auto-generated method stub
		return courseRepository.getCoursesByUserId(id);
	}

	public List<String> getTrainersByCourseId(Long id) {
		// TODO Auto-generated method stub
		return courseRepository.getTrainersByCourseId(id);
	}
	
	public DatesContainer getDatesByCourseId(Long id) {
		Course aux = courseRepository.findOne(id);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		DatesContainer dates = new DatesContainer(formatter.format(aux.getStart()), formatter.format(aux.getEnd()));
//		dates.add(formatter.format(aux.getStart()));
//		dates.add(formatter.format(aux.getEnd()));
		return dates;
	}

	public List<DatesContainer> getCoursesDates() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		List<DatesContainer> dates = new ArrayList<>();
		List<Course> courses = new ArrayList<>();
		courseRepository.findAll().forEach(courses::add);
		for(int i=0; i<courses.size(); i++) {
			DatesContainer d = new DatesContainer(formatter.format(courses.get(i).getStart()), formatter.format(courses.get(i).getEnd()));
			dates.add(d);
		}
		return dates;
	}

	public List<Course> getCoursesByTrainerId(Long id) {
		// TODO Auto-generated method stub
		return courseRepository.getCoursesByTrainerId(id);
	}

	public List<Course> getRecommendedCourses(Long id) {
		// TODO Auto-generated method stub
		List<Course> courses = courseRepository.getUnenrolledCourses(id);
		List<Course> recCourses = new ArrayList<>();
		User user = courseRepository.getUser(id);
		if (user != null) {
			String[] user_tags = user.getTags().split(",");
			for (int i=0; i<courses.size(); i++) {
				String[] course_tags = courses.get(i).getTags().split(",");
				for(int j=0; j<user_tags.length; j++)
					for(int k=0; k<course_tags.length; k++)
						if (user_tags[j].toLowerCase().equals(course_tags[k].toLowerCase()))
							recCourses.add(courses.get(i));
			}
		}
		return recCourses;
	}
}
