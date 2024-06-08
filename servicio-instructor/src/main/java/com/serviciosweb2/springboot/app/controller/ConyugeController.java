package com.serviciosweb2.springboot.app.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serviciosweb2.springboot.app.model.Conyuge;
import com.serviciosweb2.springboot.app.model.Conyuge;
import com.serviciosweb2.springboot.app.service.ConyugeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("api/v1")
public class ConyugeController {

    @Autowired
    private ConyugeService conyugueService;

    @GetMapping("/conyuges")
    public ResponseEntity<?> listar() {
        Collection<Conyuge> itemsInstructor = conyugueService.findAll(); 
        return new ResponseEntity<>(itemsInstructor, HttpStatus.OK);
    }

    @GetMapping("/conyuge/{conyugeId}")
    public ResponseEntity<?> buscar(@PathVariable Integer conyugeId) {
        Conyuge conyuge = conyugueService.findById(conyugeId);
        if(conyuge != null) {
            return new ResponseEntity<>(conyuge, HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/conyuge")
    public ResponseEntity<?> save(@RequestBody Conyuge conyuge) {
        conyugueService.save(conyuge);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    
    @PutMapping("/conyuge/{conyugeId}")
    public ResponseEntity<?> update(@PathVariable Integer conyugeId, @RequestBody Conyuge conyuge) {
        Conyuge conyugeFound = conyugueService.findById(conyugeId);
        if(conyuge != null) {
            conyugeFound.setName(conyuge.getName());
            conyugueService.save(conyuge);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/conyuge/{conyugeId}")
    public ResponseEntity<?> delete(@PathVariable Integer conyugeId) {
        Conyuge conyugeFound = conyugueService.findById(conyugeId);
        if(conyugeFound != null) {
            conyugueService.delete(conyugeId);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

}
