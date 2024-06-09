package com.serviciosweb2.springboot.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_instructores")
public class Instructor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer instructorId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(unique=true,nullable=false)
    private String email;

    @OneToOne(mappedBy = "instructor")
    @JsonManagedReference
    private Conyuge conyuge;

    @OneToMany(mappedBy = "instructor")
    @JsonManagedReference
    private Collection<Taller> talleres = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "instructores_tecnologias",
                joinColumns = @JoinColumn(name = "instructor_id", nullable = false,
                foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(instructor_id) references tb_instructores(instructor_id)")),
                inverseJoinColumns = @JoinColumn(name = "tecnologia_id", nullable = false,
                foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(tecnologia_id) references tb_tecnologias(tecnologia_id)")))
    private Set<Tecnologia> itemsTecnologia = new HashSet<>();

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

}
