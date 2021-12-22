package com.devinhouse.vilacate.rest;

import com.devinhouse.vilacate.model.entity.People;
import com.devinhouse.vilacate.services.PeopleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("peoples")
public class PeopleRest {

    @Autowired
    PeopleServices peopleServices;

    @GetMapping("/list")
    public List<People> list(){
        List<People> peoples = this.peopleServices.list();
        return peoples;
    }
}
