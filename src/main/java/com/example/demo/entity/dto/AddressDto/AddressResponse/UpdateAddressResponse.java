package com.example.demo.entity.dto.AddressDto.AddressResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAddressResponse {
    private int id;
    private String city;
    public int customerId;
}
