package com.example.springboot.app.model;

import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name= "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idEmployee")
    private long idEmployee;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "surname")
    private String surname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCountry")
    private Country country;

    @ManyToMany
    @JoinTable(
            name = "spoken_languages",
            joinColumns = @JoinColumn(name = "idEmployee"),
            inverseJoinColumns = @JoinColumn(name = "idLanguage"))
    List<Language> spokenLanguages;

    public long getId(){
        return idEmployee;
    }
    public void setId(long idEmployee){
        this.idEmployee = idEmployee;
    }

    public String getFirstname(){
        return firstname;
    }
    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public String getSurname(){
        return surname;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }

    /**public List<Language> getSpokenLanguages(){
        return spokenLanguages;
    }
    public void setSpokenLanguages(List<Language> spokenLanguages){
        this.spokenLanguages = spokenLanguages;
    }

    public Country getCountry(){
        return country;
    }
    public void setCountry(Country country){
        this.country = country;
    }**/
}
