package com.example.demo.api.endpoint;

import com.example.demo.api.exception.AddressNotFoundException;
import com.example.demo.persistence.entity.Address;
import com.example.demo.persistence.repository.AddressRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("address")
public class AddressEndpoint {
    private final AddressRepository addressRepository;

    public AddressEndpoint(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @GetMapping
    List<Address> get() {
        return addressRepository.findAll();
    }

    @GetMapping("{id}")
    Address getOne(@PathVariable Long id) {
        return addressRepository.findById(id)
                .orElseThrow(AddressNotFoundException::new);
    }

    @PostMapping
    Address post(@RequestBody Address person) {
        return addressRepository.save(person);
    }

}
