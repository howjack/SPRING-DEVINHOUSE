package com.devinhouse.vilacate.rest;

import com.devinhouse.vilacate.model.dto.FinancialDto;
import com.devinhouse.vilacate.model.dto.PeopleDto;
import com.devinhouse.vilacate.model.entity.People;
import com.devinhouse.vilacate.services.FinancialService;
import com.devinhouse.vilacate.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vilacate")
public class PeopleRest {

    @Autowired
    PeopleService peopleService;
    @Autowired
    FinancialService financialService;

    @GetMapping("/list")
    public List<People> listAllPeoples(@RequestParam(name = "mes", required = false) Integer month) {
        if (month != null) {
            return this.peopleService.listByMonth(month);
        }
        return this.peopleService.listAllPeople();
    }

    @GetMapping("/get/{id}")
    public PeopleDto peopleById(@PathVariable("id") Long id) {
        return this.peopleService.peopleById(id);
    }

    @GetMapping("/list/name")
    public List<People> listByName(@RequestParam(name = "nome") String name){
        return this.peopleService.peopleByName(name);
    }


    @GetMapping("/list/age")
    public List<PeopleDto> listByAge(@RequestParam(name = "idade") Integer age) {
        return this.peopleService.listByAge(age);
    }

    @GetMapping("/rent")
    public FinancialDto showFinancial(){
        FinancialDto financialDto = this.financialService.showFinancial();
        System.out.println(financialDto.getVillageCost());
        return financialDto;
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> createPeople(@RequestBody PeopleDto peopleDto){
        Boolean created = this.peopleService.createPeople(peopleDto);
        if(created){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deletePeople(@PathVariable("id") Long id) {
        Boolean deleted = this.peopleService.deletePeople(id);
        if (deleted){
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
