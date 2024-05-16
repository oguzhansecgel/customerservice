package com.example.demo.services;

import com.example.demo.entity.Address;
import com.example.demo.entity.Customer;
import com.example.demo.entity.CustomerInvoice;
import com.example.demo.entity.dto.CustomerDto.Request.UpdateCustomerRequest;
import com.example.demo.entity.dto.CustomerDto.Request.findByNameOrLastnameOrNationalIdRequest;
import com.example.demo.entity.dto.CustomerDto.Response.UpdateCustomerResponse;
import com.example.demo.entity.dto.CustomerDto.Response.findByNameOrLastnameOrNationalIdResponse;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface customerservice {
    List<Customer> getByAllCustomer();
    Customer getByIdCustomer(int id);
    List<Customer> findCustomers(String name, String lastname, String nationalId,Integer id);
    List<Customer> findByFirstNameStartingWithIgnoreCase(String nameStart);


    Customer addCustomers(Customer customer);
    UpdateCustomerResponse updateCustomer(UpdateCustomerRequest request);
    void deleteCustomer(int id);
}
