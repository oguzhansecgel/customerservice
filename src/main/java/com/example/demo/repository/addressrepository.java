package com.example.demo.repository;

import com.example.demo.entity.Address;
import com.example.demo.entity.dto.AddressDto.AddressResponse.GetByCustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface addressrepository extends JpaRepository<Address,Integer> {
    List<Address> findByCustomerId(int customerId);
}
