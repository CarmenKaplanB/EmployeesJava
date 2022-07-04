package com.example.springboot.app.model;
import javax.persistence.*;

@Entity
@Table(name="country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }

    public String getCode(){
        return code;
    }
    public void setCode(String code){
        this.code = code;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}