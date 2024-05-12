package com.example.demo.entity.dto.CustomerDto.Response;

import com.example.demo.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class findByNameOrLastnameOrNationalIdResponse {
    private int id;
    private String name;
    private String middleName;
    private String lastname;
    private String nationalId;
    private String mothername;
    private String fathername;
    private Gender gender;
}
