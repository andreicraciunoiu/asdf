package com.dbtechschool.repositories;

import com.dbtechschool.models.Resource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends CrudRepository<Resource, Long> {

}
