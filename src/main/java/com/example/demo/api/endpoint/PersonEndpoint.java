package com.example.demo.api.endpoint;

import com.example.demo.api.exception.PersonNotFoundException;
import com.example.demo.persistence.entity.Person;
import com.example.demo.persistence.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonEndpoint {
    private final PersonRepository personRepository;

    public PersonEndpoint(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    List<Person> get() {
        return personRepository.findAll();
    }

    @GetMapping("{id}")
    Person getOne(@PathVariable Long id) {
        return personRepository.findById(id)
                .orElseThrow(PersonNotFoundException::new);
    }

    @PostMapping
    Person post(@RequestBody Person person) {
        return personRepository.save(person);
    }
}
