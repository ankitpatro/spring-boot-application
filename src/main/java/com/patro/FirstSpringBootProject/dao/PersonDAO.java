package com.patro.FirstSpringBootProject.dao;

import com.patro.FirstSpringBootProject.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDAO {

    int addPersonWithId(UUID id, Person person);

    default int addPerson(Person person) {
        UUID uuid = UUID.randomUUID();
        return addPersonWithId(uuid, person);
    }

    List<Person> getAllPerson();

    Optional<Person> selectPersonById(UUID id);
    int removePersonById(UUID id);

    int updatePersonById(UUID id, Person person);

}
