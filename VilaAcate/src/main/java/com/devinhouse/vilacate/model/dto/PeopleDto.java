package com.devinhouse.vilacate.model.dto;

import com.devinhouse.vilacate.model.entity.People;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

public class PeopleDto implements Serializable {

    private String name;
    private String surname;
    private Date birthdate;
    private Double rent;
    private String cpf;
    private String email;
    private String password = "*******";

    public PeopleDto() {
    }

    public PeopleDto(People people) {
        this.name = people.getName();
        this.surname = people.getSurname();
        this.birthdate = people.getBirthdate();
        this.rent = people.getRent();
        this.cpf = people.getCpf();
        this.email = people.getEmail();
        this.password = people.getPassword();
    }

    public PeopleDto(String name, String surname, Date birthdate, Double rent, String cpf, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.rent = rent;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
    }

    public PeopleDto(String name, String surname, Date birthdate, Double rent, String cpf, String email) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.rent = rent;
        this.cpf = cpf;
        this.email = email;
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
        return "PeopleDto{" +
                "name='" + name + '\'' +
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
        PeopleDto peopleDto = (PeopleDto) o;
        return Objects.equals(cpf, peopleDto.cpf) && Objects.equals(email, peopleDto.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, email);
    }

    public Boolean passwordIsValid() {
        Boolean hasUppercase = false;
        Boolean hasNumber = false;
        Boolean hasSpecialChar = false;
        Boolean hasLowercase = false;


        if (!this.password.isBlank() || !this.password.equals("*******")) {
            if (this.password.length() >= 8) {
                char[] password = this.password.toCharArray();
                for (char c : password) {
                    if (isNumber(c)) hasNumber = true;
                    if (isLowerCase(c)) hasLowercase = true;
                    if (isUpperCase(c)) hasUppercase = true;
                    if (isSpecialChar(c)) hasSpecialChar = true;
                }

                return hasLowercase && hasSpecialChar && hasNumber && hasUppercase;
            }
        }
        return false;
    }

    Boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }

    Boolean isLowerCase(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    Boolean isUpperCase(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    Boolean isSpecialChar(char ch) {
        return (ch >= '!' && ch <= '/') || (ch >= ':' && ch <= '@');
    }


}
