package com.example.springboot.app.model;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCountry")
    private long idCountry;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "country")
    private Employee employee;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "idAirport")
    private List<Airport> airports;

    public long getId(){
        return idCountry;
    }
    public void setId(long idCountry){
        this.idCountry = idCountry;
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