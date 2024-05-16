package com.example.demo.services.customerinvoice;

import com.example.demo.Exception.type.BusinessException;
import com.example.demo.entity.Customer;
import com.example.demo.entity.CustomerInvoice;
import com.example.demo.repository.customerinvoicerepository;
import com.example.demo.repository.customerrepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerInvoiceServiceImpl implements customerinvoiceservice {
    private final customerinvoicerepository customerinvoicerepository;
    private final customerrepository customerrepository;
    @Override
    public List<CustomerInvoice> getByAllCustomerInvoice() {
        return customerinvoicerepository.findAll();
    }

    @Override
    public CustomerInvoice getByIdCustomerInvoice(int id) {
        Optional<CustomerInvoice> hasCustomer = customerinvoicerepository.findById(id);
        if(hasCustomer.isEmpty())
        {
            throw new BusinessException("No users with this id were found.");
        }
        return hasCustomer.get();
    }

    @Override
    public CustomerInvoice addCustomerInvoice(CustomerInvoice customerInvoice) {
        Optional<Customer> optionalCustomer = customerrepository.findById(customerInvoice.getCustomer().getId());
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customerInvoice.setAccountName(customer.getAccountNumber());
            return customerinvoicerepository.save(customerInvoice);
        } else {
            throw new IllegalArgumentException("Customer not found with ID: " + customerInvoice.getCustomer().getId());
        }
    }

    @Override
    public List<CustomerInvoice> findByCustomerId(int customerId) {
        return customerinvoicerepository.findByCustomerId(customerId);
    }

    @Override
    public CustomerInvoice updateCustomerInvoice(CustomerInvoice request) {
        return null;
    }

    @Override
    public void deleteCustomerInvoice(int id) {

    }
}
