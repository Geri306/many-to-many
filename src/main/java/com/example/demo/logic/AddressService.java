package com.example.demo.logic;

import com.example.demo.api.exception.AddressNotFoundException;
import com.example.demo.persistence.entity.Address;
import com.example.demo.persistence.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public Address findById(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(AddressNotFoundException::new);
    }

    public Address save(Address address) {
        return addressRepository.save(address);
    }

    public List<Address> saveMany(List<Address> address) {
        return addressRepository.saveAll(address);
    }

    public void delete(Long id) {
        addressRepository.deleteById(id);
    }
}
