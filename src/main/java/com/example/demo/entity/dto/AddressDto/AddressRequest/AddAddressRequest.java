package com.example.demo.entity.dto.AddressDto.AddressRequest;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddAddressRequest {

    private int id;
    private String city;
    private String district;
    private String street;
    private String houseNumber;
    private String addressDescription;
    public int customerId;
}
