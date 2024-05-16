package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String city;

    private String district;

    private String street;


    @Column(name = "house_flat_number")
    private String houseNumber;


    @Column(name = "address_description")
    private String addressDescription;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    public Customer customer;

}
