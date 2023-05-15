package com.example.demo.persistence.repository;

import com.example.demo.persistence.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
