package com.example.springboot.app.model;
import javax.persistence.*;

@Entity
@Table(name="airport")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idAirport;
    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCountry")
    private Country country;

    public long getId(){
        return idAirport;
    }
    public void setId(long idAirport){
        this.idAirport = idAirport;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}