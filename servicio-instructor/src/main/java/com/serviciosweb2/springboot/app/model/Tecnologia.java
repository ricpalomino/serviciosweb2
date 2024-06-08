package com.serviciosweb2.springboot.app.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "tb_tecnologias")
@Entity
public class Tecnologia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tecnologiaId;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "itemsTecnologia", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Instructor> itemsInstructor = new HashSet<>();

}
