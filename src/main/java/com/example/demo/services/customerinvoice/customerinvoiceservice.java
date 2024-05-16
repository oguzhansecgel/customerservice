package com.example.demo.services.customerinvoice;

import com.example.demo.entity.CustomerInvoice;

import java.util.List;

public interface customerinvoiceservice {
    List<CustomerInvoice> getByAllCustomerInvoice();
    CustomerInvoice getByIdCustomerInvoice(int id);
    CustomerInvoice addCustomerInvoice(CustomerInvoice customerInvoice);
    List<CustomerInvoice> findByCustomerId(int customerId);
    CustomerInvoice updateCustomerInvoice(CustomerInvoice request);
    void deleteCustomerInvoice(int id);


}
