package com.mini.jobportal.contact.controller;


import com.mini.jobportal.contact.service.ContactServiceImpl;
import com.mini.jobportal.dto.ContactDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactController {

    public final ContactServiceImpl contactService;

//     public ContactController(ContactServiceImpl contactService) {
//        this.contactService = contactService;
//    }

//    @PostMapping(version = "1.0")
//    public String saveContact() {
//        return "Contact saved successfully";
//    }

    @PostMapping(version = "1.0")
    public ResponseEntity<String> saveContact(@RequestBody ContactDto contactDto){
        boolean isSaved = contactService.saveContact(contactDto);
        if(isSaved) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Contact created successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save contact");
        }

    }
}
