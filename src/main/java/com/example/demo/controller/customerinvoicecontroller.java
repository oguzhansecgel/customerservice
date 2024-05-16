package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.entity.CustomerInvoice;
import com.example.demo.services.customerinvoice.customerinvoiceservice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customerinvoice")
@RequiredArgsConstructor
public class customerinvoicecontroller {
    private final customerinvoiceservice customerinvoiceservice;
    @GetMapping("GetAll")
    public List<CustomerInvoice> getAllCustomer()
    {
        return  customerinvoiceservice.getByAllCustomerInvoice();
    }
    @GetMapping("GetByIdCustomer")
    public CustomerInvoice getByIdCustomer(@RequestParam int id)
    {
        return customerinvoiceservice.getByIdCustomerInvoice(id);
    }
    @GetMapping("FindByCustomerInvoiceAccount")
    public List<CustomerInvoice> findByCustomerId(int customerId)
    {
        return customerinvoiceservice.findByCustomerId(customerId);
    }
    @PostMapping
    public CustomerInvoice createCustomerInvoice(@RequestBody CustomerInvoice customerInvoice)
    {
        return customerinvoiceservice.addCustomerInvoice(customerInvoice);
    }
}
