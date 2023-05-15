package com.example.demo.api.endpoint;

import com.example.demo.api.exception.PersonNotFoundException;
import com.example.demo.logic.PersonService;
import com.example.demo.persistence.entity.Person;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonEndpoint {
    private final PersonService personService;

    public PersonEndpoint(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    List<Person> get() {
        return personService.findAll();
    }

    @GetMapping("{id}")
    Person getOne(@PathVariable Long id) {
        return personService.findById(id)
                .orElseThrow(PersonNotFoundException::new);
    }

    @PostMapping
    Person post(@RequestBody Person person) {
        return personService.save(person);
    }
}
