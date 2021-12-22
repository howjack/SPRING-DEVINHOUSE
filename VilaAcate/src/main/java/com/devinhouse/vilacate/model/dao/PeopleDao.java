package com.devinhouse.vilacate.model.dao;

import com.devinhouse.vilacate.model.entity.People;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PeopleDao {

    public List<People> peoples = new ArrayList<>(Arrays.asList(
            new People(1L, "Pedro", "almeida", LocalDate.of(1998, 6, 26), 800.20, "999.999.999-99", "pedro@", "limão55")
    ));

    public List<People> list(){
        return peoples;
    }

}
