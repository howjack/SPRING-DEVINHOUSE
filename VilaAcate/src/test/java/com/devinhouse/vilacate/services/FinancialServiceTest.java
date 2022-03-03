package com.devinhouse.vilacate.services;

import com.devinhouse.vilacate.model.dto.FinancialDto;
import com.devinhouse.vilacate.model.entity.People;
import com.devinhouse.vilacate.model.repository.PeopleRepository;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FinancialServiceTest extends TestCase {

    PeopleRepository peopleRepository;
    private FinancialService financialService;

    @BeforeEach
    void beforeEach(){
        peopleRepository = Mockito.mock(PeopleRepository.class);
        this.financialService = new FinancialService(peopleRepository);

        financialService.villageCost = 70000.00;
    }

    @Test
    void showFinancial() {
        List<People> peoples = new ArrayList<>(Arrays.asList(
                new People(
                        1L,
                        "joão",
                        "almeida",
                        new Date(1998, 7, 22),
                        200.00,
                        "1041567892",
                        "asd@asd.com",
                        "aasd"),
                new People(
                        2L,
                        "pedro",
                        "juca",
                        new Date(1995, 1, 15),
                        500.00,
                        "1041156284",
                        "asd@asd.com",
                        "aasd")
        ));

        Iterable<People> peoplesIt = peoples;
        Mockito.when(peopleRepository.findAll()).thenReturn(peoplesIt);

        FinancialDto financialDto = financialService.showFinancial();

        System.out.println(financialDto);
    }
}