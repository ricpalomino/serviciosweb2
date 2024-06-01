package com.serviciosweb2.springboot.app.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.serviciosweb2.springboot.app.model.Instructor;
import com.serviciosweb2.springboot.app.repository.InstructorRepository;

@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    @Override
    @Transactional(readOnly = false)
    public void save(Instructor instructor) {
        instructorRepository.save(instructor);
    }

    @Override
    public void delete(Integer instructorId) {
        instructorRepository.deleteById(instructorId);
    }

    @Override
    public Instructor findById(Integer instructorId) {
        return instructorRepository.findById(instructorId).orElse(null);
    }

    @Override
    public Collection<Instructor> findAll() {
        return (Collection<Instructor>) instructorRepository.findAll();
    }

}
