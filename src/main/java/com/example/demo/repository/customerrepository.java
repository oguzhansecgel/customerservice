package com.example.demo.repository;

import com.example.demo.entity.Customer;
import com.example.demo.entity.CustomerInvoice;
import com.example.demo.entity.dto.CustomerDto.Request.findByNameOrLastnameOrNationalIdRequest;
import com.example.demo.entity.dto.CustomerDto.Response.findByNameOrLastnameOrNationalIdResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface customerrepository extends JpaRepository<Customer, Integer> {


    List<Customer> findByNameOrLastnameOrNationalIdOrId(String name, String lastname, String nationalId,Integer id);

    @Query("SELECT c FROM Customer c WHERE LOWER(c.name) LIKE LOWER(CONCAT(:nameStart, '%'))")
    List<Customer> findByFirstNameStartingWithIgnoreCase(@Param("nameStart") String nameStart);


    // nationalid var mı yok mu kontrolü
    boolean existsByNationalId(String nationalId);

}
