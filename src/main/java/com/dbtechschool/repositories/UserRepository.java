package com.dbtechschool.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dbtechschool.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
