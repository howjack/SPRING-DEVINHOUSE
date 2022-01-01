package com.devinhouse.vilacate.services;

import com.devinhouse.vilacate.model.dao.PeopleDao;
import com.devinhouse.vilacate.model.dto.FinancialDto;
import com.devinhouse.vilacate.model.entity.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class FinancialService {

    @Value("${rent.villagecost}")
    private Double villageCost;

    @Autowired
    PeopleDao peopleDao;
    
    public FinancialDto showFinancial(){
        Double peoplesRent = 0.;
        People higherRentPerson = null;
        try {
            List<People> peoples = this.peopleDao.listPeoples();
            for (People people: peoples) {
                peoplesRent = peoplesRent + people.getRent();
                if (higherRentPerson == null || people.getRent() > higherRentPerson.getRent()){
                    higherRentPerson = people;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new FinancialDto(villageCost, peoplesRent, higherRentPerson.generateDTO());
    }
}
