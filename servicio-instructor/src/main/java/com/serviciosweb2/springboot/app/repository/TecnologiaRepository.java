package com.serviciosweb2.springboot.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.serviciosweb2.springboot.app.model.Tecnologia;

@Repository
public interface TecnologiaRepository extends CrudRepository<Tecnologia, Integer>{

}
