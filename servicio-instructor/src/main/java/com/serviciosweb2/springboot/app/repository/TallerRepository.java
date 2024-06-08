package com.serviciosweb2.springboot.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.serviciosweb2.springboot.app.model.Taller;

@Repository
public interface TallerRepository extends CrudRepository<Taller, Integer>{

}
