package com.example.demo.logic;

import com.example.demo.api.exception.PersonNotFoundException;
import com.example.demo.persistence.entity.Person;
import com.example.demo.persistence.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(PersonNotFoundException::new);
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public List<Person> saveMany(List<Person> person) {
        return personRepository.saveAll(person);
    }

    public void delete(Long id) {
        personRepository.deleteById(id);
    }
}
