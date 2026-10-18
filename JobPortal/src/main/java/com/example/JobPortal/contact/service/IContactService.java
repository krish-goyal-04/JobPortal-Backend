package com.example.JobPortal.contact.service;

import com.example.JobPortal.dto.ContactRequestDto;

public interface IContactService {
    boolean saveContact(ContactRequestDto contactRequestDto);
}
