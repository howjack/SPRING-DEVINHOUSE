package com.devinhouse.vilacate.services;

import com.devinhouse.vilacate.model.dto.PeopleDto;
import com.devinhouse.vilacate.model.entity.People;
import com.devinhouse.vilacate.model.repository.PeopleRepository;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Date;
import java.util.*;

class PeopleServiceTest extends TestCase {

    private PeopleRepository peopleRepository;
    private PeopleService peopleService;

    @BeforeEach
    void beforeEach(){
        peopleRepository = Mockito.mock(PeopleRepository.class);
        this.peopleService = new PeopleService(peopleRepository);
    }

    @Test
    void listAllPeople() {
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

        List<PeopleDto> peoplesDto = new ArrayList<>();
        peoplesIt.forEach( people -> peoplesDto.add(new PeopleDto(people)));

        List<PeopleDto> peoplesTesting = peopleService.listAllPeople();

        assertEquals(peoplesDto, peoplesTesting);
    }

    @Test
    void peopleById() {
        People people = new People(
                1L,
                "joão",
                "almeida",
                new Date(1998, 7, 22),
                200.00,
                "1041567892",
                "asd@asd.com",
                "aasd"
        );

        Long id = 2L;

        Mockito.when(peopleRepository.findById(Mockito.any(Long.class))).thenReturn(Optional.of(people));

        PeopleDto peopleDto = peopleService.peopleById(Mockito.any(Long.class));

        assertEquals(new PeopleDto(people), peopleDto);
    }

    @Test
    void peopleByName() {
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
                        "jonathan",
                        "juca",
                        new Date(1995, 1, 15),
                        500.00,
                        "1041156284",
                        "asd@asd.com",
                        "aasd")

        ));

        Iterable<People> peoplesIt = peoples;
        Mockito.when(peopleRepository.findAllByNameContaining(Mockito.any())).thenReturn(peoplesIt);

        List<PeopleDto> peoplesDto = new ArrayList<>();
        peoplesIt.forEach( people -> peoplesDto.add(new PeopleDto(people)));

        List<PeopleDto> peopleTesting = peopleService.peopleByName("jo");

        assertEquals(peoplesDto, peopleTesting);
    }

    @Test
    void listByMonth() {
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
                        "jonathan",
                        "juca",
                        new Date(1995, 7, 15),
                        500.00,
                        "1041156284",
                        "asd@asd.com",
                        "aasd")

        ));

        Mockito.when(peopleRepository.findAllByMonth(7)).thenReturn(peoples);

        List<PeopleDto> peoplesDto = new ArrayList<>();
        peoples.forEach( people -> peoplesDto.add(new PeopleDto(people)));

        List<PeopleDto> peopleTesting = peopleService.listByMonth(7);

        assertEquals(peoplesDto, peopleTesting);
    }

    @Test
    void listByAge() {
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
                        "jonathan",
                        "juca",
                        new Date(1995, 7, 15),
                        500.00,
                        "1041156284",
                        "asd@asd.com",
                        "aasd")

        ));

        Mockito.when(peopleRepository.findAllByYear(2000)).thenReturn(peoples);

        List<PeopleDto> peoplesDto = new ArrayList<>();
        peoples.forEach( people -> peoplesDto.add(new PeopleDto(people)));

        List<PeopleDto> peopleTesting = peopleService.listByAge(22);

        assertEquals(peoplesDto, peopleTesting);
    }

    @Test
    void createPeople() {
        People people = new People(
                1L,
                "joão",
                "almeida",
                new Date(1998, 7, 22),
                200.00,
                "1234567895",
                "asd@asd.com",
                "Phelipe!182"
        );

        Mockito.when(peopleRepository.save(Mockito.any(People.class))).thenReturn(people);

        People peopleTesting = peopleService.createPeople(new PeopleDto(people));

        assertEquals(people, peopleTesting);
    }
}