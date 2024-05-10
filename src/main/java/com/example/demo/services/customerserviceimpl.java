package com.example.demo.services;

import com.example.demo.Exception.type.BusinessException;
import com.example.demo.entity.customer;
import com.example.demo.repository.customerrepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class customerserviceimpl implements customerservice{

    public final customerrepository customerrepository;
    @Override
    public List<customer> findCustomers(String name, String lastname, String nationalId) {

       List<customer> customers = customerrepository.findByNameOrLastnameOrNationalId(name,lastname,nationalId);
        if(customers.isEmpty())
        {
            throw new BusinessException("No customer found! Would you like to create the customer?");
        }
        return customerrepository.findByNameOrLastnameOrNationalId(name, lastname, nationalId);
    }

    @Override
    public List<customer> findByFirstNameStartingWithIgnoreCase(String nameStart) {
        return customerrepository.findByFirstNameStartingWithIgnoreCase(nameStart);
    }

    @Override
    public customer addCustomers(customer customer) {
        boolean hasNationalId = customerrepository.existsByNationalId(customer.getNationalId());
        if(hasNationalId)
        {
            throw new BusinessException("Böyle bir kimliğe sahip kullanıcı bulunmakta");
        }
        return customerrepository.save(customer);
    }



}
