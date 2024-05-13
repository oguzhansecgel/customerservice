package com.example.demo.services;

import com.example.demo.Exception.type.BusinessException;
import com.example.demo.entity.Address;
import com.example.demo.entity.Customer;
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
    public List<Customer> findCustomers(String name, String lastname, String nationalId, String gsmnumber,int id) {
        if (gsmnumber != null) {
            if (gsmnumber.length() != 11) {
                throw new BusinessException("GSM number must be 11 characters long");
            }

            // Pozitif bir tam sayı olup olmadığını kontrol edin
            try {
                long gsmNumber2 = Long.parseLong(gsmnumber);
                if (gsmNumber2 <= 0) {
                    throw new BusinessException("GSM number must be a positive integer");
                }
            } catch (NumberFormatException e) {
                throw new BusinessException("GSM number must be a valid integer");
            }
        }

        List<Customer> customers = customerrepository.findByNameOrLastnameOrNationalIdOrGsmnumberOrId(name, lastname, nationalId, gsmnumber,id);
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
        // GSM numarasının uzunluğunu kontrol edin
        if (customer.getGsmnumber().length() != 11) {
            throw new BusinessException("GSM number must be 11 characters long");
        }

        // Pozitif bir tam sayı olup olmadığını kontrol edin
        try {
            long gsmNumber = Long.parseLong(customer.getGsmnumber());
            if (gsmNumber <= 0) {
                throw new BusinessException("GSM number must be a positive integer");
            }
        } catch (NumberFormatException e) {
            throw new BusinessException("GSM number must be a valid integer");
        }

        // Diğer kontrolleri yapın ve müşteriyi kaydedin
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
        return new UpdateCustomerResponse(savedCustomer.getId(),
                savedCustomer.getName(),
                savedCustomer.getMiddleName(),
                savedCustomer.getLastname(),
                savedCustomer.getNationalId(),
                savedCustomer.getMothername(),
                savedCustomer.getFathername(),
                savedCustomer.getGender(),
                savedCustomer.getGsmnumber());
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
