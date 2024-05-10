package com.example.demo.services;

import com.example.demo.entity.customer;

import java.util.List;

public interface customerservice {
    List<customer> findCustomers(String name, String lastname, String nationalId);
    List<customer> findByFirstNameStartingWithIgnoreCase(String nameStart);
    customer addCustomers(customer customer);

}
