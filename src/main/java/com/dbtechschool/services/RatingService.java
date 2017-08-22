package com.dbtechschool.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.dbtechschool.models.Enrollment;
import com.dbtechschool.models.Rating;
import com.dbtechschool.models.Section;
import com.dbtechschool.repositories.RatingRepository;

@Service
public class RatingService {

	@Autowired
	RatingRepository ratingRepository;

	public List<Rating> findAllRatings() {
		return ((List<Rating>) ratingRepository.findAll());
	}
	
	public Rating getById(int id) {
		return ratingRepository.findOne(id);
	}
	
	public void deleteById(int id) {
		ratingRepository.delete(id);
	}
	
	public void deleteAll() {
		ratingRepository.deleteAll();
	}
	
	public void insertRating(@RequestBody Rating r) {
		ratingRepository.save(r);
	}
	
	public void updateRatingById(Integer rating, Section section, Enrollment enrollment, int id) {
		ratingRepository.updateRatingById(rating, section, enrollment, id);
	}
	
	
	
}
