package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Customer  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "account_number")
    private int accountNumber;

    @NotBlank(message = "This field is required")
    @Size(max = 50,message = "Maksimum 50 karakterlik veri girişi yapınız.")
    private String name;
    @Column(name = "middlename")
    @Size(max = 50,message = "Maksimum 50 karakterlik veri girişi yapınız.")
    private String middleName;
    @NotBlank(message = "This field is required")
    @Size(max = 50,message = "Maksimum 50 karakterlik veri girişi yapınız.")
    private String lastname;
    @NotBlank(message = "This field is required")
    private String nationalId;
    private String mothername;
    private String fathername;
    @Column(name = "birth_date")
    private Date birthdate;

    private Gender gender;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Address> Addresses;

    @JsonIgnore
    @OneToOne(mappedBy ="customer")
    private ContactMedium contactMedium;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<CustomerInvoice> invoices;

    //TODO : birth date eklenecek
    //TODO : national id 11 karakterleri bir pozitif tam sayı girmesini sağlanacak


}
