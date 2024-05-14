package com.example.demo.services.contactmedium;

import com.example.demo.Exception.type.BusinessException;
import com.example.demo.entity.Address;
import com.example.demo.entity.ContactMedium;
import com.example.demo.entity.Customer;
import com.example.demo.entity.dto.ContactMediumDto.CreateContactMediumRequest;
import com.example.demo.mapper.ModelMapperService;
import com.example.demo.repository.ContactMediumRepository;
import com.example.demo.repository.customerrepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@AllArgsConstructor
public class ContactMediumServiceImpl implements ContactMediumService {
    private final ContactMediumRepository contactMediumRepository;
    private final ModelMapperService modelMapperService;
    private final customerrepository customerrepository;
    public ContactMedium createContactMedium(CreateContactMediumRequest request) {
        if (request.getMobilephone().length() != 11) {
            throw new BusinessException("GSM number must be 11 characters long");
        }

        try {
            long gsmNumber = Long.parseLong(request.getMobilephone());
            if (gsmNumber <= 0) {
                throw new BusinessException("GSM number must be a positive integer");
            }
        } catch (NumberFormatException e) {
            throw new BusinessException("GSM number must be a valid integer");
        }

        Customer customer = customerrepository.findById(request.getCustomerId())
                .orElseThrow(() -> new BusinessException("Customer not found with id: " + request.getCustomerId()));

        ContactMedium newContactMedium = modelMapperService.forRequest().map(request, ContactMedium.class);
        newContactMedium.setCustomer(customer);

        return contactMediumRepository.save(newContactMedium);
    }
}
