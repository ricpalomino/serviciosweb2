package com.serviciosweb2.springboot.app.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.serviciosweb2.springboot.app.model.Instructor;

@Repository
public class InstructorRepositoryImpl implements InstructorRepository {

    public static Collection<Instructor> itemsInstructor = new ArrayList<>();

    @Override
    public void insert(Instructor instructor) {
        itemsInstructor.add(instructor);
    }

    @Override
    public void upddate(Instructor instructor) {
        Instructor oldInstructor = findById(instructor.getInstructorId());
        itemsInstructor.remove(oldInstructor);
        insert(instructor);
    }

    @Override
    public void delete(Integer instructorId) {
        Instructor instructor = findById(instructorId);
        itemsInstructor.remove(instructor);
    }

    @Override
    public Instructor findById(Integer instructorId) {
        Optional<Instructor> instructor = itemsInstructor.stream().filter(i -> i.getInstructorId() ==  instructorId).findFirst();
        return instructor.orElse(null);
    }

    @Override
    public Collection<Instructor> findAll() {
        return itemsInstructor;
    }

}
