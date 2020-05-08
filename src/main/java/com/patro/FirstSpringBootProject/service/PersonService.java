package com.patro.FirstSpringBootProject.service;

import com.patro.FirstSpringBootProject.dao.PersonDAO;
import com.patro.FirstSpringBootProject.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDAO personDAO;

    @Autowired
    public PersonService(@Qualifier("db1") PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public int addPerson(Person person) {
        return personDAO.addPerson(person);
    }

    public List<Person> getAllPersons() {
        return personDAO.getAllPerson();
    }

    public Optional<Person> getPersonById(UUID id) {
        return personDAO.selectPersonById(id);
    }

    public int removePerson(UUID id) {
        return personDAO.removePersonById(id);
    }

    public int updatePerson(UUID id, Person person) {
        return personDAO.updatePersonById(id, person);
    }


}
