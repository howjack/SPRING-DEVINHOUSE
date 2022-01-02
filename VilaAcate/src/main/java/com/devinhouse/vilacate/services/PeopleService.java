package com.devinhouse.vilacate.services;

import com.devinhouse.vilacate.model.dao.PeopleDao;
import com.devinhouse.vilacate.model.dto.PeopleDto;
import com.devinhouse.vilacate.model.entity.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PeopleService {

    @Autowired
    PeopleDao peopleDao;

    public List<People> listAllPeople() {
        List<People> list = new ArrayList<>();
        try {
            list = this.peopleDao.listPeoples();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public PeopleDto peopleById(Long id) {
        PeopleDto people = null;
        try {
            people = this.peopleDao.peopleById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return people;
    }

    public List<People> peopleByName(String name) {
        String nameUppercase = name.substring(0, 1).toUpperCase() + name.substring(1);
        List<People> peoples = new ArrayList<>();
        try {
            peoples = this.peopleDao.peopleByName(nameUppercase);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peoples;
    }


    public List<People> listByMonth(Integer month) {
        List<People> peoples = new ArrayList<>();
        try {
            peoples = this.peopleDao.listPeoplesByMonth(month);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peoples;
    }

    public List<PeopleDto> listByAge(Integer age) {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        List<PeopleDto> peoples = new ArrayList<>();
        try {
            for (People people : this.peopleDao.listPeoplesByAge(year - age)) {
                peoples.add(people.generateDTO());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peoples;
    }

    public Boolean createPeople(PeopleDto peopleDto) {
        try {
            if (!peopleDto.passwordIsValid()) return false;
            this.peopleDao.createPeople(peopleDto);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Boolean deletePeople(Long id) {
        try {
            this.peopleDao.deletePeople(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
