package com.example.demo.api.endpoint;

import com.example.demo.api.exception.AddressNotFoundException;
import com.example.demo.api.exception.PersonNotFoundException;
import com.example.demo.persistence.entity.Address;
import com.example.demo.persistence.entity.Person;
import com.example.demo.persistence.repository.AddressRepository;
import com.example.demo.persistence.repository.PersonRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("personaddress")
public class PersonAddressEndpoint {
    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    public PersonAddressEndpoint(PersonRepository personRepository, AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
    }

    @PutMapping("{addressId}/{personId}")
    Person put(@PathVariable Long addressId, @PathVariable Long personId) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(AddressNotFoundException::new);
        Person person = personRepository.findById(personId)
                .orElseThrow(PersonNotFoundException::new);
        person.addAddress(address);
        return personRepository.save(person);
    }

}
