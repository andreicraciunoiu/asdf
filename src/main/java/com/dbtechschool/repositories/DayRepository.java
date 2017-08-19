package com.dbtechschool.repositories;

import com.dbtechschool.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends CrudRepository<User, Long> {

}
