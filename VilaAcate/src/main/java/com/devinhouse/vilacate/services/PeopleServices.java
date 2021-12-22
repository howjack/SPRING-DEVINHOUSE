package com.devinhouse.vilacate.services;

import com.devinhouse.vilacate.model.dao.PeopleDao;
import com.devinhouse.vilacate.model.entity.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeopleServices {
    
    @Autowired
    PeopleDao peopleDao;
    
    public List<People> list(){
        List<People> list = new ArrayList<>();
        list = this.peopleDao.list();
        return list;
    }
}
