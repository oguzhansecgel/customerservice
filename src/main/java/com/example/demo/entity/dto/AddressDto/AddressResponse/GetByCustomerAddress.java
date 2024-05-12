package com.example.demo.entity.dto.AddressDto.AddressResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByCustomerAddress {

    private int id;
    private String city;
    private int customerId;

}
