package com.example.demo.entity.dto.CustomerDto.Response;

import com.example.demo.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerResponse {
    private int id;
    private String name;
    private String middleName;
    private String lastname;
    private String nationalId;
    private String mothername;
    private String fathername;
    private Gender gender;
    private String Gsmnumber;
}
