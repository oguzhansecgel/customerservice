package com.example.demo.controller;

import com.example.demo.entity.Address;
import com.example.demo.entity.dto.AddressDto.AddressRequest.AddAddressRequest;
import com.example.demo.entity.dto.AddressDto.AddressResponse.AddAddressResponse;
import com.example.demo.entity.dto.AddressDto.AddressResponse.GetByCustomerAddress;
import com.example.demo.services.address.addressservice;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/address")
public class addresscontroller {

    private final addressservice addressservice;

    public addresscontroller(com.example.demo.services.address.addressservice addressservice) {
        this.addressservice = addressservice;
    }


    @GetMapping
    public List<Address> getAllAddress()
    {
        return addressservice.getAll();
    }
    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody AddAddressRequest request)
    {
        Address response = addressservice.createAddress(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.ok(response);
    }
    @GetMapping("/addresses")
    public ResponseEntity<List<GetByCustomerAddress>> findByCustomerId(@RequestParam int customerId) {
        List<GetByCustomerAddress> addresses = addressservice.findByCustomerId(customerId);
        return ResponseEntity.ok(addresses);
    }
    @DeleteMapping("DeleteAddress")
    public void deletedAddress(@RequestParam int id)
    {
        addressservice.deleteAddress(id);
    }
}
