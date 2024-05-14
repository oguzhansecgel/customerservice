package com.example.demo.services.address;

import com.example.demo.Exception.type.BusinessException;
import com.example.demo.entity.Address;
import com.example.demo.entity.Customer;
import com.example.demo.entity.dto.AddressDto.AddressRequest.AddAddressRequest;
import com.example.demo.entity.dto.AddressDto.AddressRequest.UpdateAddressRequest;
import com.example.demo.entity.dto.AddressDto.AddressResponse.AddAddressResponse;
import com.example.demo.entity.dto.AddressDto.AddressResponse.GetByCustomerAddress;
import com.example.demo.entity.dto.AddressDto.AddressResponse.UpdateAddressResponse;
import com.example.demo.mapper.ModelMapperService;
import com.example.demo.repository.addressrepository;
import com.example.demo.repository.customerrepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class addressserviceimpl implements addressservice{

    private final addressrepository addressrepository;
    private final ModelMapperService modelMapperService;
    private final customerrepository customerrepository;


    @Override
    public Address updateAddress(Address address) {
        return addressrepository.saveAndFlush(address);
    }

    @Override
    public Address createAddress(AddAddressRequest request) {
        Customer customer = customerrepository.findById(request.getCustomerId())
                .orElseThrow(() -> new BusinessException("Customer not found with id: " + request.getCustomerId()));

        Address newAddress = modelMapperService.forRequest().map(request, Address.class);
        newAddress.setCustomer(customer);


       return addressrepository.save(newAddress);
        //return //new AddAddressResponse(savedAddress.getId(), savedAddress.getCity());
    }

    @Override
    public UpdateAddressResponse updateAddress(UpdateAddressRequest request) {

        Address address = modelMapperService.forRequest().map(request, Address.class);
        Address savedAddres = addressrepository.saveAndFlush(address);

        return new UpdateAddressResponse(savedAddres.getId(),savedAddres.getCity(),savedAddres.getCustomer().getId());
    }

    @Override
    public void deleteAddress(int id) {
        Optional<Address> addressOptional = addressrepository.findById(id);
        if (addressOptional.isEmpty()) {
            throw new BusinessException("Address not found with id: " + id);
        }

        // Müşteriye ait en az bir adresin olup olmadığını kontrol et
        Address address = addressOptional.get();
        Customer customer = address.getCustomer();
        List<Address> customerAddresses = customer.getAddresses();
        if (customerAddresses.size() <= 1) {
            throw new BusinessException("A customer must have at least one address.");
        }

        // Adresi sil
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
