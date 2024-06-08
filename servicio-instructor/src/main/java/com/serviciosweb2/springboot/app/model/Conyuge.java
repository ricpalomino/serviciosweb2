package com.serviciosweb2.springboot.app.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_conyuges")
public class Conyuge implements Serializable{

    @Id
    private Long conyugeDni;

    @Column(nullable = false)
    private String name;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "instructor_id", nullable = false, unique = true, foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(instructor_id) references tb_instructores(instructor_id)"))
    private Instructor instructor;


}
