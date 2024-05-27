package com.serviciosweb2.springboot.app.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Instructor implements Serializable {

    private Integer instructorId;
    private String name;
    private String lastname;
    private String password;
    private String email;
    private Date createAt;

}
