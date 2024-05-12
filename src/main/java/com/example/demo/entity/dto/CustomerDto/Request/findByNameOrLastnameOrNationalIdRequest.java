package com.example.demo.entity.dto.CustomerDto.Request;

import com.example.demo.entity.Gender;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class findByNameOrLastnameOrNationalIdRequest {
    private String name;
    private String middleName;
    private String lastname;
    private String nationalId;
    private String mothername;
    private String fathername;
    private Gender gender;
}
