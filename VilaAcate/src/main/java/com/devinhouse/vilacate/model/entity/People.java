package com.devinhouse.vilacate.model.entity;

import com.devinhouse.vilacate.model.dto.PeopleDto;
import org.springframework.data.annotation.Id;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class People {

    private Long id;
    private String name;
    private String surname;
    private Date birthdate;
    private Double rent;
    private String cpf;
    private String email;
    private String password = "*******";

    public People() {
    }

    public People(Long id, String name, String surname, Date birthdate, Double rent, String cpf, String email, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.rent = rent;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
    }

    public People(Long id, String name, String surname, Date birthdate, Double rent, String cpf, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.rent = rent;
        this.cpf = cpf;
        this.email = email;
    }

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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Double getRent() {
        return rent;
    }

    public void setRent(Double rent) {
        this.rent = rent;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {

        return "people{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthdate=" + birthdate +
                ", rent=" + rent +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return id.equals(people.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public PeopleDto generateDTO(){
        return new PeopleDto(this.name,this.surname, this.birthdate, this.rent, this.cpf, this.email, this.password);
    }
}
