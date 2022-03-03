package com.devinhouse.vilacate.model.entity;

import com.devinhouse.vilacate.model.dto.PeopleDto;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 60)
    private String name;

    @Column(length = 60)
    private String surname;

    @Column(nullable = false)
    private Date birthdate;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double rent;

    @Column(length = 60, unique = true, nullable = false)
    private String cpf;

    @Column(length = 255, unique = true, nullable = false)
    private String email;

    @Column(length = 255, nullable = false)
    private String password = "*******";

    public People() {
    }

    public People(PeopleDto peopleDto) {
        this.name = peopleDto.getName();
        this.surname = peopleDto.getSurname();
        this.birthdate = peopleDto.getBirthdate();
        this.rent = peopleDto.getRent();
        this.cpf = peopleDto.getCpf();
        this.email = peopleDto.getEmail();
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

    public Long getId() {
        return id;
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
