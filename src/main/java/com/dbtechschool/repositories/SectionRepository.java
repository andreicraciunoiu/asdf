package com.dbtechschool.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dbtechschool.models.Section;

@Repository
public interface SectionRepository extends CrudRepository<Section, Long> {

}
