package com.example.springboot.app.model;

import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name= "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "surname")
    private String surname;

    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }

    public String getFirstname(){
        return firstname;
    }
    public void setFirstname(String name){
        this.firstname = firstname;
    }

    public String getSurname(){
        return surname;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }


}


