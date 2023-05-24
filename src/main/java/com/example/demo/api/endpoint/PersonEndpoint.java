package com.example.demo.api.endpoint;

import com.example.demo.logic.RegistryService;
import com.example.demo.logic.PersonService;
import com.example.demo.persistence.entity.Person;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonEndpoint {
    private final PersonService personService;
    private final RegistryService registryService;

    public PersonEndpoint(PersonService personService, RegistryService registryService) {
        this.personService = personService;
        this.registryService = registryService;
    }

    @GetMapping
    List<Person> get() {
        return personService.findAll();
    }

    @GetMapping("{id}")
    Person getOne(@PathVariable Long id) {
        return personService.findById(id);
    }

    @PostMapping
    Person post(@RequestBody Person person) {
        return personService.save(person);
    }

    @PostMapping("many")
    List<Person> postMany(@RequestBody List<Person> person) {
        return personService.saveMany(person);
    }

    @DeleteMapping
    void delete(@PathVariable Long id) {
        personService.delete(id);
    }
}
