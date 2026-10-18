package com.example.JobPortal.contact.service.impl;

import com.example.JobPortal.contact.service.IContactService;
import com.example.JobPortal.dto.ContactRequestDto;
import com.example.JobPortal.entity.Contact;
import com.example.JobPortal.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements IContactService {

    private final ContactRepository contactRepository;
    @Override
    public boolean saveContact(ContactRequestDto contactRequestDto){
        Contact savedContact = contactRepository.save(transformToEntity(contactRequestDto));
        if(savedContact!=null && savedContact.getId()!=null)return true;
        return false;
    }

    private Contact transformToEntity(ContactRequestDto contactRequestDto){
        Contact contact = new Contact();
        BeanUtils.copyProperties(contactRequestDto,contact);
        contact.setCreatedAt(Instant.now());
        contact.setCreatedBy("System");
        contact.setStatus("New");
        return contact;
    }
}
