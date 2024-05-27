package com.serviciosweb2.springboot.app.service;

import java.util.Collection;

import com.serviciosweb2.springboot.app.model.Instructor;

public interface InstructorService {

    public abstract void insert(Instructor instructor);
    public abstract void upddate(Instructor instructor);
    public abstract void delete(Integer instructorId);
    public abstract Instructor findById(Integer instructorId);
    public abstract Collection<Instructor> findAll();

}
