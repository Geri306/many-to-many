package com.example.demo.persistence.repository;

import com.example.demo.persistence.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
