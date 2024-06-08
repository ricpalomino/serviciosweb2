package com.serviciosweb2.springboot.app.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serviciosweb2.springboot.app.model.Conyuge;
import com.serviciosweb2.springboot.app.repository.ConyugeRepository;

@Service
public class ConyugeServiceImpl implements ConyugeService {

    @Autowired
    private ConyugeRepository conyugeRepository;

    @Override
    public void save(Conyuge conyuge) {
        conyugeRepository.save(conyuge);
    }

    @Override
    public void delete(Integer conyugeId) {
        conyugeRepository.deleteById(conyugeId);
    }

    @Override
    public Conyuge findById(Integer conyugeId) {
        return conyugeRepository.findById(conyugeId).orElse(null);
    }

    @Override
    public Collection<Conyuge> findAll() {
        return (Collection<Conyuge>) conyugeRepository.findAll();
    }

}
