package com.example.demo.services.address;

import com.example.demo.entity.Address;
import com.example.demo.entity.dto.AddressDto.AddressRequest.AddAddressRequest;
import com.example.demo.entity.dto.AddressDto.AddressResponse.AddAddressResponse;
import com.example.demo.entity.dto.AddressDto.AddressResponse.GetByCustomerAddress;
import com.example.demo.mapper.ModelMapperService;
import com.example.demo.repository.addressrepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class addressserviceimpl implements addressservice{

    private final addressrepository addressrepository;
    private final ModelMapperService modelMapperService;
    public addressserviceimpl(com.example.demo.repository.addressrepository addressrepository, ModelMapperService modelMapperService) {
        this.addressrepository = addressrepository;
        this.modelMapperService = modelMapperService;
    }


    @Override
    public Address updateAddress(Address address) {
        return addressrepository.saveAndFlush(address);
    }

    @Override
    public AddAddressResponse createAddress(AddAddressRequest request) {
        Address address = this.modelMapperService.forRequest().map(request,Address.class);
        Address savedAddress = addressrepository.save(address);
        return new AddAddressResponse(savedAddress.getId(), savedAddress.getCity());

    }

    @Override
    public void deleteAddress(int id) {
        addressrepository.deleteById(id);

    }

    @Override
    public List<Address> getAll() {
        return addressrepository.findAll();
    }

    @Override
    public List<GetByCustomerAddress> findByCustomerId(int customerId) {
        List<Address> addresses = addressrepository.findByCustomerId(customerId);
        return addresses.stream()
                .map(address -> modelMapperService.forResponse().map(address, GetByCustomerAddress.class))
                .collect(Collectors.toList());
    }
}
