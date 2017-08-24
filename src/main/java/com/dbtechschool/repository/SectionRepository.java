package com.dbtechschool.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dbtechschool.model.Section;

@Repository
public interface SectionRepository extends CrudRepository<Section, Long> {

}
