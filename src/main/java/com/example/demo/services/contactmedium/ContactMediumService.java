package com.example.demo.services.contactmedium;

import com.example.demo.entity.ContactMedium;
import com.example.demo.entity.dto.ContactMediumDto.CreateContactMediumRequest;

public interface ContactMediumService {

    ContactMedium createContactMedium(CreateContactMediumRequest request);
}
