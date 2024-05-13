package com.example.demo.controller;

import com.example.demo.entity.Address;
import com.example.demo.entity.Customer;
import com.example.demo.entity.dto.AddressDto.AddressResponse.AddAddressResponse;
import com.example.demo.entity.dto.CustomerDto.Request.UpdateCustomerRequest;
import com.example.demo.entity.dto.CustomerDto.Response.UpdateCustomerResponse;
import com.example.demo.services.customerservice;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("customer/api")
@AllArgsConstructor
public class customercontroller {

    public customerservice customerservice;

    @GetMapping("GetAll")
    public List<Customer> getAllCustomer()
    {
        return  customerservice.getByAllCustomer();
    }
    @GetMapping("GetByIdCustomer")
    public Customer getByIdCustomer(@RequestParam int id)
    {
        return customerservice.getByIdCustomer(id);
    }
    @GetMapping("FindByNameOrLastNameOrNationalIdOrGsmNumberOrCustomerId")
    public List<Customer> getByParamsAll(@RequestParam(required = false) String name,
                                         @RequestParam(required = false) String lastName,
                                         @RequestParam(required = false) String nationalId,
                                         @RequestParam(required = false) String gsmnumber,
                                         @RequestParam(required = false) int id) {
        return customerservice.findCustomers(name, lastName, nationalId,gsmnumber,id);
    }
    @GetMapping("FindByStartName")
    public List<Customer> getByLikeName(@RequestParam(required = false) String startName)
    {
        return customerservice.findByFirstNameStartingWithIgnoreCase(startName);
    }

    @PostMapping("CreateCustomer")
    public Customer addCustomer(@RequestBody @Valid Customer customer)
    {
        return customerservice.addCustomers(customer);
    }
    @PutMapping
    public ResponseEntity<UpdateCustomerResponse> updateCustomer(@RequestBody @Valid UpdateCustomerRequest request)
    {
        UpdateCustomerResponse response = customerservice.updateCustomer(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(location).body(response);
    }
    @DeleteMapping("delete")
    public void deletedCustomer(@RequestParam int id)
    {
        customerservice.deleteCustomer(id);
    }
}

