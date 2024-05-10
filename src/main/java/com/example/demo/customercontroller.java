package com.example.demo;

import com.example.demo.entity.customer;
import com.example.demo.services.customerservice;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer/api")
@AllArgsConstructor
public class customercontroller {

    public customerservice customerservice;

    @GetMapping
    public List<customer> getByParamsAll(@RequestParam(required = false) String name,
                                   @RequestParam(required = false) String lastName,
                                   @RequestParam(required = false) String nationalId) {
        return customerservice.findCustomers(name, lastName, nationalId);
    }
    @GetMapping("startName")
    public List<customer> getByLikeName(@RequestParam(required = false) String startName)
    {
        return customerservice.findByFirstNameStartingWithIgnoreCase(startName);
    }
    @PostMapping
    public customer addCustomer(@RequestBody @Valid customer customer)
    {
        return customerservice.addCustomers(customer);
    }
}

