package com.dbtechschool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dbtechschool.models.Rating;
import com.dbtechschool.services.RatingService;

@RestController
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	@RequestMapping(value = "/ratings", method = RequestMethod.GET)
	public List<Rating> getAllRatings(){
		return ratingService.findAllRatings();
	}
	
	@RequestMapping(value = "/rating/{id}", method = RequestMethod.GET)
	public Rating getById(@PathVariable(value = "id") Integer id) {
		return ratingService.getById(id);
	}

	@RequestMapping(value = "/rating/{id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable(value = "id") Integer id) {
		ratingService.deleteById(id);
	}

	@RequestMapping(value = "/clear/ratings", method = RequestMethod.DELETE)
	public void deleteAll() {
		ratingService.deleteAll();
	}

	@RequestMapping(value = "/rating", method = RequestMethod.POST)
	public void insertRating(@RequestBody Rating r) {
		ratingService.insertRating(r);
	}

	@RequestMapping(value = "/rating/{id}", method = RequestMethod.PUT)
	public void updateRating(@RequestBody Rating r, @PathVariable(value = "id") int id) {
		ratingService.updateRatingById(r.getRating(), r.getSection(), r.getEnrollment(), id);
	}
	

}
