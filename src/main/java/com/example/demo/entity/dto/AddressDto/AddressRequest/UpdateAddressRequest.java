package com.example.demo.entity.dto.AddressDto.AddressRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAddressRequest {
    private int id;
    private String city;
    private String district;
    private String street;
    private String houseNumber;
    private String addressDescription;
    public int customerId;
}
