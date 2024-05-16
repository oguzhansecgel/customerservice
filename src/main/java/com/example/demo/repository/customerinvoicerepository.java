package com.example.demo.repository;

import com.example.demo.entity.CustomerInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface customerinvoicerepository extends JpaRepository<CustomerInvoice,Integer> {
    List<CustomerInvoice> findByCustomerId(int customerId);

}
