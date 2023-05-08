package com.example.practice66bit.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String gender;
    private java.sql.Date birthDate;
    private String team;
    private String country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return birthDate;
    }

    public void setDateOfBirth(java.sql.Date dateOfBirth) {
        this.birthDate = dateOfBirth;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return id + ". " + name + " " + surname + ", " +
                gender + ", " + birthDate + ", " +
                team + ", " + country;
    }
}
