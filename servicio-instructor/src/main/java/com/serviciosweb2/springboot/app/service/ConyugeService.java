package com.serviciosweb2.springboot.app.service;

import java.util.Collection;

import com.serviciosweb2.springboot.app.model.Conyuge;

public interface ConyugeService {

    public abstract void save(Conyuge conyuge);
    public abstract void delete(Integer conyugeId);
    public abstract Conyuge findById(Integer conyugeId);
    public abstract Collection<Conyuge> findAll();

}
