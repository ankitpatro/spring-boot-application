package com.patro.FirstSpringBootProject.dao;

import com.patro.FirstSpringBootProject.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("db1")
public class PersonDAOImpl implements PersonDAO {

    private static List<Person> persons = new ArrayList<>();

    @Override
    public int addPersonWithId(UUID id, Person person) {
        persons.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> getAllPerson() {
        return persons;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return persons.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public int removePersonById(UUID id) {
        Optional<Person> personMaybe = selectPersonById(id);
        if (personMaybe != null) {
            persons.remove(personMaybe.get());
            return 1;
        }
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return selectPersonById(id).map(person1 -> {
           int indexOfPerson = persons.indexOf(person1);
           if(indexOfPerson >= 0 ) {
               persons.set(indexOfPerson, new Person(id, person.getName()));
               return 1;
           }
           return 0;
        }).orElse(0);
    }
}
