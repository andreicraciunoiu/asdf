package com.dbtechschool.repositories;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dbtechschool.models.Enrollment;
import com.dbtechschool.models.Rating;
import com.dbtechschool.models.Section;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Integer> {

	@Modifying
	@Transactional
	@Query("update Rating r set r.rating = ?1, r.section = ?2, r.enrollment = ?3 where r.id = ?7")
	int updateRatingById(Integer rating, Section section, Enrollment enrollment, int id);

}
