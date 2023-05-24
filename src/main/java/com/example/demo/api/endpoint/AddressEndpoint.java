package com.example.demo.api.endpoint;

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
        return addressService.findById(id);
    }

    @PostMapping
    Address post(@RequestBody Address address) {
        return addressService.save(address);
    }

    @PostMapping("many")
    List<Address> postMany(@RequestBody List<Address> address) {
        return addressService.saveMany(address);
    }

    @DeleteMapping
    void delete(@PathVariable Long id) {
        addressService.delete(id);
    }

}
