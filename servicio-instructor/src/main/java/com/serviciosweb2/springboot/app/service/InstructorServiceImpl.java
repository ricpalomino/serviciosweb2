package com.serviciosweb2.springboot.app.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serviciosweb2.springboot.app.model.Instructor;
import com.serviciosweb2.springboot.app.repository.InstructorRepository;

@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    @Override
    public void insert(Instructor instructor) {
        instructorRepository.insert(instructor);
    }

    @Override
    public void upddate(Instructor instructor) {
        instructorRepository.upddate(instructor);
    }

    @Override
    public void delete(Integer instructorId) {
        instructorRepository.delete(instructorId);
    }

    @Override
    public Instructor findById(Integer instructorId) {
        return instructorRepository.findById(instructorId);
    }

    @Override
    public Collection<Instructor> findAll() {
        return instructorRepository.findAll();
    }

}
