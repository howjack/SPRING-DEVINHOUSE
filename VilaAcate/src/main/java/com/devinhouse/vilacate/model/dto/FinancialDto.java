package com.devinhouse.vilacate.model.dto;

import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

public class FinancialDto implements Serializable {

    private static final long serialVersionUID = 145561451L;
    private Double villageCost;
    private Double differenceSpent;
    private Double peoplesRent;
    private PeopleDto higherRentPerson;

    public FinancialDto() {
    }

    public FinancialDto(Double villageCost, Double peoplesRent, PeopleDto higherRentPerson) {
        this.higherRentPerson = higherRentPerson;
        this.peoplesRent = peoplesRent;
        this.villageCost = villageCost;

        this.differenceSpent = villageCost - peoplesRent;
    }

    public Double getVillageCost() {
        return villageCost;
    }

    public Double getDifferenceSpent() {
        return differenceSpent;
    }

    public Double getPeoplesRent() {
        return peoplesRent;
    }

    public void setPeoplesRent(Double peoplesRent) {
        this.peoplesRent = peoplesRent;
    }

    public PeopleDto getHigherRentPerson() {
        return higherRentPerson;
    }

    public void setHigherRentPerson(PeopleDto higherRentPerson) {
        this.higherRentPerson = higherRentPerson;
    }

    @Override
    public String toString() {
        return "FinancialDao{" +
                "villageCost=" + villageCost +
                ", differenceSpent=" + differenceSpent +
                ", peoplesRent=" + peoplesRent +
                ", higherRentPerson=" + higherRentPerson +
                '}';
    }

}
