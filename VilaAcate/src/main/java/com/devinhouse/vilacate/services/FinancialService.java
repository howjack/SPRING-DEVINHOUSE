package com.devinhouse.vilacate.services;

import com.devinhouse.vilacate.model.dto.FinancialDto;
import com.devinhouse.vilacate.model.entity.People;
import com.devinhouse.vilacate.model.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class FinancialService {

    @Value("${rent.villagecost}")
    public Double villageCost;

    PeopleRepository peopleRepository;

    public FinancialService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public FinancialDto showFinancial() throws NullPointerException{
        Double peoplesRent = 0.;
        People higherRentPerson = null;
        Iterable<People> peoples = this.peopleRepository.findAll();
        for (People people: peoples) {
            peoplesRent = peoplesRent + people.getRent();
            if (higherRentPerson == null || people.getRent() > higherRentPerson.getRent()){
                higherRentPerson = people;
            }
        }
        return new FinancialDto(villageCost, peoplesRent, higherRentPerson.generateDTO());
    }
}
