package com.kgl1688.entity;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@Entity(name = "user")
@XmlRootElement
public class User {

    public User() {
        super();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "first_name", length = 32)
    private String first_name;
    @Column(name = "age")
    private Integer age;
    @Column(name = "last_name", length = 32)
    private String last_name;

}
