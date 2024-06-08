package com.serviciosweb2.springboot.app.service;

import java.util.Collection;

import com.serviciosweb2.springboot.app.model.Tecnologia;

public interface TecnologiaService {

    public abstract void save(Tecnologia tecnologia);
    public abstract void delete(Integer tecnologiaId);
    public abstract Tecnologia findById(Integer tecnologiaId);
    public abstract Collection<Tecnologia> findAll();
}
