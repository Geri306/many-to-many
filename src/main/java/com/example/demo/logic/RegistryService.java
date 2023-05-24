package com.example.demo.logic;

import com.example.demo.persistence.entity.Address;
import com.example.demo.persistence.entity.Person;
import org.springframework.stereotype.Service;

@Service
public class RegistryService {

    private final PersonService personService;
    private final AddressService addressService;

    public RegistryService(PersonService personService, AddressService addressService) {
        this.personService = personService;
        this.addressService = addressService;
    }

    public void join(Long personId, Long addressId) {
        Person person = personService.findById(personId);
        Address address = addressService.findById(addressId);
        person.addAddress(address);
        personService.save(person);
    }

    public void decouple(Long personId, Long addressId) {
        Person person = personService.findById(personId);
        Address address = addressService.findById(addressId);
        person.removeAddress(address);
        personService.save(person);
    }
}
