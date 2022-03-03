package com.devinhouse.vilacate.rest;

import com.devinhouse.vilacate.model.dto.FinancialDto;
import com.devinhouse.vilacate.model.dto.PeopleDto;
import com.devinhouse.vilacate.model.entity.People;
import com.devinhouse.vilacate.services.FinancialService;
import com.devinhouse.vilacate.services.PeopleService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vilacate")
public class PeopleRest {

    private PeopleService peopleService;
    private FinancialService financialService;
    private RabbitTemplate rabbitTemplate;

    public PeopleRest(PeopleService peopleService, FinancialService financialService, RabbitTemplate rabbitTemplate) {
        this.peopleService = peopleService;
        this.financialService = financialService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/list")
    public List<PeopleDto> listAllPeoples(@RequestParam(name = "mes", required = false) Integer month) {
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
    public List<PeopleDto> listByName(@RequestParam(name = "nome") String name){
        return this.peopleService.peopleByName(name);
    }


    @GetMapping("/list/age")
    public List<PeopleDto> listByAge(@RequestParam(name = "idade") Integer age) {
        return this.peopleService.listByAge(age);
    }

    @GetMapping("/rent")
    public FinancialDto showFinancial(){
        FinancialDto financialDto = this.financialService.showFinancial();
        rabbitTemplate.convertAndSend("FinancialExchange","acate.*", financialDto);
        return financialDto;
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> createPeople(@RequestBody PeopleDto peopleDto){
        People created = this.peopleService.createPeople(peopleDto);
        if(created != null){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deletePeople(@PathVariable("id") Long id) {
        if (id == null){
            throw new IllegalArgumentException("Erro ID vazio!");
        }

        this.peopleService.deletePeople(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
