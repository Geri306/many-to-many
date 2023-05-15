package com.example.demo.api.endpoint;

import com.example.demo.api.exception.AddressNotFoundException;
import com.example.demo.logic.AddressService;
import com.example.demo.persistence.entity.Address;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("address")
public class AddressEndpoint {
    private final AddressService addressService;

    public AddressEndpoint(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    List<Address> get() {
        return addressService.findAll();
    }

    @GetMapping("{id}")
    Address getOne(@PathVariable Long id) {
        return addressService.findById(id)
                .orElseThrow(AddressNotFoundException::new);
    }

    @PostMapping
    Address post(@RequestBody Address address) {
        return addressService.save(address);
    }

}
