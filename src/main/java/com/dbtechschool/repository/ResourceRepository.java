package com.dbtechschool.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dbtechschool.model.Resource;

@Repository
public interface ResourceRepository extends CrudRepository<Resource, Integer> {

    @Modifying
    @Transactional
    @Query("update Resource r set r.name = ?1, r.link = ?2 where r.id = ?3")
    int updateResourceById(String name, String link, int id);

}
