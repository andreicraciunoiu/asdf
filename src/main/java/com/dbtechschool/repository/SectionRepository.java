package com.dbtechschool.repository;

import com.dbtechschool.model.Day;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dbtechschool.model.Section;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface SectionRepository extends CrudRepository<Section, Long> {
    @Query("select s from Section s where s.day.id = :id")
    List<Section> getByDay(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("update Section s set s.name = ?1, s.start = ?2, s.end = ?3, s.room = ?4, s.trainer = ?5, s.description = ?6, s.ratingAvg = ?7, s.day = ?8 where s.id = ?9")
    int updateSectionbyId(String name, Date start, Date end, String room, String trainer, String description,
                          Double ratingAvg, Day day, Long id);
}
