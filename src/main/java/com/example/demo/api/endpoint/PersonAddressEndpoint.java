package com.example.demo.api.endpoint;

import com.example.demo.api.exception.AddressNotFoundException;
import com.example.demo.api.exception.PersonNotFoundException;
import com.example.demo.logic.AddressService;
import com.example.demo.logic.PersonService;
import com.example.demo.persistence.entity.Address;
import com.example.demo.persistence.entity.Person;
import com.example.demo.persistence.repository.AddressRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("personaddress")
public class PersonAddressEndpoint {
    private final PersonService personService;
    private final AddressService addressService;

    public PersonAddressEndpoint(PersonService personService, AddressService addressService) {
        this.personService = personService;
        this.addressService = addressService;
    }

    @PutMapping("{addressId}/{personId}")
    Person put(@PathVariable Long addressId, @PathVariable Long personId) {
        Address address = addressService.findById(addressId)
                .orElseThrow(AddressNotFoundException::new);
        Person person = personService.findById(personId)
                .orElseThrow(PersonNotFoundException::new);
        person.addAddress(address);
        return personService.save(person);
    }

}
