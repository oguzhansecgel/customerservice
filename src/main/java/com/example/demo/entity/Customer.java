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

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;
    @NotBlank(message = "This field is required")
    @Size(max = 50,message = "Maksimum 50 karakterlik veri girişi yapınız.")
    public String name;
    @Column(name = "middlename")
    @Size(max = 50,message = "Maksimum 50 karakterlik veri girişi yapınız.")
    public String middleName;
    @NotBlank(message = "This field is required")
    @Size(max = 50,message = "Maksimum 50 karakterlik veri girişi yapınız.")
    public String lastname;
    @NotBlank(message = "This field is required")
    public String nationalId;
    public String mothername;
    public String fathername;
    @Column(name = "birth_date")
    public Date birthdate;
    @NotBlank
    @Size(max = 11,min = 11,message = "GSM numarası formatında başında 0 olacak şekilde 11 haneli veri girişi yapınız")
    public String gsmnumber;
    public Gender gender;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Address> Addresses;



    //TODO : birth date eklenecek
    //TODO : national id 11 karakterleri bir pozitif tam sayı girmesini sağlanacak


}
