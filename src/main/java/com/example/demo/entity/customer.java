package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class customer {

    @jakarta.persistence.Id
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
    public Gender gender;

}
