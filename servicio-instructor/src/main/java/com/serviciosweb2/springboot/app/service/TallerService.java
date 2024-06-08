package com.serviciosweb2.springboot.app.service;

import java.util.Collection;

import com.serviciosweb2.springboot.app.model.Taller;

public interface TallerService {

    public abstract void save(Taller taller);
    public abstract void delete(Integer tallerId);
    public abstract Taller findById(Integer tallerId);
    public abstract Collection<Taller> findAll();

}
