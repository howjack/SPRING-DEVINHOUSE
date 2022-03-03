package com.devinhouse.vilacate.services;

import com.devinhouse.vilacate.model.dto.PeopleDto;
import com.devinhouse.vilacate.model.entity.People;
import com.devinhouse.vilacate.model.repository.PeopleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    PeopleRepository peopleRepository;

    public PeopleService(PeopleRepository peopleRepository){
        this.peopleRepository = peopleRepository;
    }

    public List<PeopleDto> listAllPeople() {
        List<PeopleDto> list = new ArrayList<>();
        Iterable<People> iterable = this.peopleRepository.findAll();
        iterable.forEach( people -> list.add(new PeopleDto(people)));
        return list;
    }

    public PeopleDto peopleById(Long id) {
        Optional<People> people = this.peopleRepository.findById(id);
        if (people.isPresent()){
            return new PeopleDto(people.get());
        }
        throw new RuntimeException("Dont Exist this People");
    }

    public List<PeopleDto> peopleByName(String name) {
        String nameUppercase = name.substring(0, 1).toUpperCase() + name.substring(1);
        List<PeopleDto> peoplesDto = new ArrayList<>();
        Iterable<People> iterable = this.peopleRepository.findAllByNameContaining(nameUppercase);
        iterable.forEach( people -> peoplesDto.add(new PeopleDto(people)));
        return peoplesDto;
    }

    public List<PeopleDto> listByMonth(Integer month) {
        List<PeopleDto> peoplesDTO = new ArrayList<>();
        List<People> peoples;
        peoples = this.peopleRepository.findAllByMonth(month);
        peoples.forEach( people -> peoplesDTO.add(new PeopleDto(people)));
        return peoplesDTO;
    }

    public List<PeopleDto> listByAge(Integer age) {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        List<PeopleDto> peoplesDto = new ArrayList<>();
        for (People people : this.peopleRepository.findAllByYear(year - age)) {
            peoplesDto.add(new PeopleDto(people));
        }
        return peoplesDto;
    }

    public People createPeople(PeopleDto peopleDto) {
        if (!peopleDto.passwordIsValid()){
            throw new RuntimeException("Password is invalid");
        }
        return this.peopleRepository.save(new People(peopleDto));
    }

    public void deletePeople(Long id) {
        this.peopleRepository.deleteById(id);
    }
}
