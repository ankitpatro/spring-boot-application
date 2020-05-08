package com.patro.FirstSpringBootProject.api;

import com.patro.FirstSpringBootProject.model.Person;
import com.patro.FirstSpringBootProject.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id)
    {
        return  personService.getPersonById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void removePersonById(@PathVariable("id") UUID id)
    {
         personService.removePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePersonById(@PathVariable("id") UUID id, @RequestBody Person personToUpdate)
    {
        personService.updatePerson(id, personToUpdate);
    }


}
