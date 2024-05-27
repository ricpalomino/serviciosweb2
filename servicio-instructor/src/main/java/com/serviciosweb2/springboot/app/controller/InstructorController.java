package com.serviciosweb2.springboot.app.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serviciosweb2.springboot.app.model.Instructor;
import com.serviciosweb2.springboot.app.service.InstructorService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("api/v1")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @GetMapping("/instructors")
    public ResponseEntity<?> listar() {
        Collection<Instructor> itemsInstructor = instructorService.findAll(); 
        return new ResponseEntity<>(itemsInstructor, HttpStatus.OK);
    }

    @GetMapping("/instructor/{instructorId}")
    public ResponseEntity<?> buscar(@PathVariable Integer instructorId) {
        Instructor instructor = instructorService.findById(instructorId);
        if(instructor != null) {
            return new ResponseEntity<>(instructor, HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/instructor")
    public ResponseEntity<?> save(@RequestBody Instructor instructor) {
        instructorService.insert(instructor);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    
    @PutMapping("/instructor/{instructorId}")
    public ResponseEntity<?> update(@PathVariable Integer instructorId, @RequestBody Instructor instructor) {
        Instructor instructorFound = instructorService.findById(instructorId);
        if(instructor != null) {
            instructorFound.setName(instructor.getName());
            instructorFound.setEmail(instructor.getEmail());
            instructorFound.setPassword(instructor.getPassword());
            instructorFound.setLastname(instructor.getLastname());
            instructorFound.setCreateAt(instructor.getCreateAt());
            instructorService.upddate(instructorFound);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/instructor/{instructorId}")
    public ResponseEntity<?> delete(@PathVariable Integer instructorId) {
        Instructor instructorFound = instructorService.findById(instructorId);
        if(instructorFound != null) {
            instructorService.delete(instructorId);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

}
