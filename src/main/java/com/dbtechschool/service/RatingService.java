package com.dbtechschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.dbtechschool.model.Enrollment;
import com.dbtechschool.model.Rating;
import com.dbtechschool.model.Section;
import com.dbtechschool.repository.RatingRepository;

@Service
public class RatingService {

	@Autowired
	RatingRepository ratingRepository;

	public List<Rating> findAllRatings() {
		return ((List<Rating>) ratingRepository.findAll());
	}
	
	public Rating getById(Long id) {
		return ratingRepository.findOne(id);
	}
	
	public void deleteById(Long id) {
		ratingRepository.delete(id);
	}
	
	public void deleteAll() {
		ratingRepository.deleteAll();
	}
	
	public void insertRating(@RequestBody Rating r) {
		ratingRepository.save(r);
	}
	
	public void updateRatingById(Integer rating, Section section, Enrollment enrollment, Long id) {
		ratingRepository.updateRatingById(rating, section, enrollment, id);
	}
	
	
	
}
