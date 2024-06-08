package com.serviciosweb2.springboot.app.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.serviciosweb2.springboot.app.model.Tecnologia;
import com.serviciosweb2.springboot.app.repository.TecnologiaRepository;

public class TecnologiaServiceImpl implements TecnologiaService{

    @Autowired
    private TecnologiaRepository tecnologiaRepository;

    @Override
    public void save(Tecnologia tecnologia) {
        tecnologiaRepository.save(tecnologia);
    }

    @Override
    public void delete(Integer tecnologiaId) {
        tecnologiaRepository.deleteById(tecnologiaId);
    }

    @Override
    public Tecnologia findById(Integer tecnologiaId) {
        return tecnologiaRepository.findById(tecnologiaId).orElse(null);
    }

    @Override
    public Collection<Tecnologia> findAll() {
        return (Collection<Tecnologia>) tecnologiaRepository.findAll();
    }

}
