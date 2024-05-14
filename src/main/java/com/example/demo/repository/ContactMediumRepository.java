package com.example.demo.repository;

import com.example.demo.entity.ContactMedium;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactMediumRepository extends JpaRepository<ContactMedium,Integer> {
}
