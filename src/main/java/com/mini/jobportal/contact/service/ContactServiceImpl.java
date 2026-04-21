package com.mini.jobportal.contact.service;


import com.mini.jobportal.dto.ContactDto;
import com.mini.jobportal.entity.Contact;
import com.mini.jobportal.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements IContactService{

    private final ContactRepository contactRepository;

    @Override
    public boolean saveContact(ContactDto contactDto) {
        boolean res = false;
        Contact contact = contactRepository.save(transformToEntity(contactDto));
        if(contact != null && contact.getId() != null) {
            res = true;
        }
        return res;
    }

    public Contact transformToEntity(ContactDto contactDto) {
        Contact contact = new Contact();
        BeanUtils.copyProperties(contactDto, contact);
        contact.setCreatedAt(Instant.now());
        contact.setCreatedBy("System");
        contact.setStatus("NEW");
        return contact;
    }
}
