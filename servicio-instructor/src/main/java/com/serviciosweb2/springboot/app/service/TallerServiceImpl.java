package com.serviciosweb2.springboot.app.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.serviciosweb2.springboot.app.model.Taller;
import com.serviciosweb2.springboot.app.repository.TallerRepository;

public class TallerServiceImpl implements TallerService{

    @Autowired
    private TallerRepository tallerRepository;

    @Override
    public void save(Taller taller) {
        tallerRepository.save(taller);
    }

    @Override
    public void delete(Integer tallerId) {
        tallerRepository.deleteById(tallerId);
    }

    @Override
    public Taller findById(Integer tallerId) {
        return tallerRepository.findById(tallerId).orElse(null);
    }

    @Override
    public Collection<Taller> findAll() {
        return (Collection<Taller>) tallerRepository.findAll();
    }

}
