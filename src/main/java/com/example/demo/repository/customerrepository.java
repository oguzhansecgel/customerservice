package com.example.demo.repository;

import com.example.demo.entity.customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface customerrepository extends JpaRepository<customer, Integer> {


    List<customer> findByNameOrLastnameOrNationalId(String name, String lastname, String nationalId);
    @Query("SELECT c FROM customer c WHERE LOWER(c.name) LIKE LOWER(CONCAT(:nameStart, '%'))")
    List<customer> findByFirstNameStartingWithIgnoreCase(@Param("nameStart") String nameStart);
    boolean existsByNationalId(String nationalId);
}
