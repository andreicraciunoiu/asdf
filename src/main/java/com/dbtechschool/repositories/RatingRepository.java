package com.dbtechschool.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dbtechschool.models.Rating;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {

}
