package com.example.demo.services;

import com.example.demo.Exception.type.BusinessException;
import com.example.demo.entity.Address;
import com.example.demo.entity.Customer;
import com.example.demo.entity.CustomerInvoice;
import com.example.demo.entity.Gender;
import com.example.demo.entity.dto.AddressDto.AddressResponse.AddAddressResponse;
import com.example.demo.entity.dto.AddressDto.AddressResponse.GetByCustomerAddress;
import com.example.demo.entity.dto.CustomerDto.Request.UpdateCustomerRequest;
import com.example.demo.entity.dto.CustomerDto.Request.findByNameOrLastnameOrNationalIdRequest;
import com.example.demo.entity.dto.CustomerDto.Response.UpdateCustomerResponse;
import com.example.demo.mapper.ModelMapperService;
import com.example.demo.repository.customerrepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class customerserviceimpl implements customerservice{

    private final customerrepository customerrepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<Customer> findCustomers(String name, String lastname, String nationalId,Integer id) {


        List<Customer> customers = customerrepository.findByNameOrLastnameOrNationalIdOrId(name, lastname, nationalId,id);
        if (customers.isEmpty()) {
            throw new BusinessException("No customer found! Would you like to create the customer?");
        }

        return customers;
    }


    public List<Customer> findByFirstNameStartingWithIgnoreCase(String nameStart) {
        return customerrepository.findByFirstNameStartingWithIgnoreCase(nameStart);
    }


    @Override
    public Customer getByIdCustomer(int id) {
        Optional<Customer> hasCustomer = customerrepository.findById(id);
        if(hasCustomer.isEmpty())
        {
            throw new BusinessException("No users with this id were found.");
        }
        return hasCustomer.get();
    }

    @Override
    public Customer addCustomers(Customer customer) {

        boolean hasNationalId = customerrepository.existsByNationalId(customer.getNationalId());
        if (hasNationalId) {
            throw new BusinessException("A customer is already exist with this Nationality ID");
        }
        return customerrepository.save(customer);
    }

    @Override
    public UpdateCustomerResponse updateCustomer(UpdateCustomerRequest request) {
        boolean hasNationalId = customerrepository.existsByNationalId(request.getNationalId());
        if (hasNationalId) {
            throw new BusinessException("A customer is already exist with this Nationality ID");
        }
        Customer customer = this.modelMapperService.forRequest().map(request,Customer.class);
        Customer savedCustomer = customerrepository.saveAndFlush(customer);
        return new UpdateCustomerResponse();
    }

    @Override
    public void deleteCustomer(int id) {
        //TODO:Eğer ilgili müşterinin aktif bir ürünü varsa “Since the customer has active products, the customer cannot be deleted.” uyarı mesajı gösterilecek ve müşteri silinmeyecektir.
        customerrepository.deleteById(id);
    }

    @Override
    public List<Customer> getByAllCustomer() {
        return customerrepository.findAll();
    }




}
