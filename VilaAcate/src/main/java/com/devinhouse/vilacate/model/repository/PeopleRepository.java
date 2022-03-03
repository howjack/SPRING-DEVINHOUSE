package com.devinhouse.vilacate.model.repository;

import com.devinhouse.vilacate.model.entity.People;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleRepository extends CrudRepository<People, Long> {

    @Query(value = "SELECT * FROM people WHERE EXTRACT(MONTH FROM birthdate) = :month", nativeQuery = true)
    public List<People> findAllByMonth(Integer month);

    public Iterable<People> findAllByNameContaining(String name);

    @Query(value = "SELECT * FROM people WHERE EXTRACT(YEAR FROM birthdate) <= :year", nativeQuery = true)
    public Iterable<People> findAllByYear(Integer year);
}
