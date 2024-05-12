package com.example.demo.entity.dto.AddressDto.AddressResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllAddressResponse {
    private int Id;
    private String city;
}
