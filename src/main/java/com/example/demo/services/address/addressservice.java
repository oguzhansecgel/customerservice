package com.example.demo.services.address;

import com.example.demo.entity.Address;
import com.example.demo.entity.dto.AddressDto.AddressRequest.AddAddressRequest;
import com.example.demo.entity.dto.AddressDto.AddressRequest.UpdateAddressRequest;
import com.example.demo.entity.dto.AddressDto.AddressResponse.AddAddressResponse;
import com.example.demo.entity.dto.AddressDto.AddressResponse.GetByCustomerAddress;
import com.example.demo.entity.dto.AddressDto.AddressResponse.UpdateAddressResponse;

import java.util.List;

public interface addressservice {
    Address updateAddress(Address address);
    Address createAddress(AddAddressRequest request);
    UpdateAddressResponse updateAddress(UpdateAddressRequest request);
    void deleteAddress(int id);
    List<Address> getAll();
    List<GetByCustomerAddress> findByCustomerId(int customerId);


}
