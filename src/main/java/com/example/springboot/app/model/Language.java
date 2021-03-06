package com.example.springboot.app.model;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "spokenLanguages")
    List<Employee> speaks;

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
    public void set(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }
}


