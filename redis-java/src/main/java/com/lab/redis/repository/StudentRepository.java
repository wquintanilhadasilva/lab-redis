package com.lab.redis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lab.redis.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {

}
