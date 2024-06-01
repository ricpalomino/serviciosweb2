package com.serviciosweb2.springboot.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.serviciosweb2.springboot.app.model.Instructor;

public interface InstructorRepository extends CrudRepository<Instructor, Integer> {

}
