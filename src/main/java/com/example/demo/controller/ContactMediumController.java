package com.example.demo.controller;

import com.example.demo.entity.ContactMedium;
import com.example.demo.entity.dto.ContactMediumDto.CreateContactMediumRequest;
import com.example.demo.services.contactmedium.ContactMediumService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("contactmedium")
public class ContactMediumController {
    private final ContactMediumService contactMediumService;

    public ContactMediumController(ContactMediumService contactMediumService) {
        this.contactMediumService = contactMediumService;
    }


    @PostMapping("CreatedContactMedium")
    public void createContactMedium(@RequestBody CreateContactMediumRequest request)
    {
        contactMediumService.createContactMedium(request);
    }
}
