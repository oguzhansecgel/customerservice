package com.example.demo.entity;

import com.example.demo.Exception.type.BusinessException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "customer_invoice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerInvoice  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "account_name")
    private int accountName;

    @Column(name = "account_status")
    private AccountStatus accountStatus;

    @Column(name = "account_type")
    private AccountType accountType;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
