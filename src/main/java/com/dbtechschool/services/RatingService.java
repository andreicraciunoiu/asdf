package com.dbtechschool.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbtechschool.models.Rating;
import com.dbtechschool.repositories.RatingRepository;

@Service
public class RatingService {

	@Autowired
	RatingRepository ratingRepository;

	public List<Rating> findAllCourses() {
		return ((List<Rating>) ratingRepository.findAll());
	}
}
