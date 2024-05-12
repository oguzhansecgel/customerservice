package com.example.demo.services;

import com.example.demo.Exception.type.BusinessException;
import com.example.demo.entity.Address;
import com.example.demo.entity.Customer;
import com.example.demo.entity.dto.AddressDto.AddressResponse.GetByCustomerAddress;
import com.example.demo.entity.dto.CustomerDto.Request.findByNameOrLastnameOrNationalIdRequest;
import com.example.demo.mapper.ModelMapperService;
import com.example.demo.repository.customerrepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class customerserviceimpl implements customerservice{

    private final customerrepository customerrepository;

    @Override
    public List<Customer> findCustomers(String name, String lastname, String nationalId) {
        List<Customer> Customers = customerrepository.findByNameOrLastnameOrNationalId(name,lastname,nationalId);
        if(Customers.isEmpty())
        {
            throw new BusinessException("No customer found! Would you like to create the customer?");
        }
        return customerrepository.findByNameOrLastnameOrNationalId(name, lastname, nationalId);
    }

    public List<Customer> findByFirstNameStartingWithIgnoreCase(String nameStart) {
        return customerrepository.findByFirstNameStartingWithIgnoreCase(nameStart);
    }



    @Override
    public Customer addCustomers(Customer customer) {
        // kayıt edilen customerin national idsi var mı yok mu kontrolü
        boolean hasNationalId = customerrepository.existsByNationalId(customer.getNationalId());
        if(hasNationalId)
        {
            throw new BusinessException("A customer is already exist with this Nationality ID");
        }
        return customerrepository.save(customer);
    }



}
