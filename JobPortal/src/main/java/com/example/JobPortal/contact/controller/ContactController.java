package com.example.JobPortal.contact.controller;

import com.example.JobPortal.contact.service.IContactService;
import com.example.JobPortal.dto.ContactRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactController {

    public final IContactService contactService;

    @PostMapping
    public ResponseEntity<String> saveContactMessage(@RequestBody ContactRequestDto contactRequestDto){
        boolean isSaved = contactService.saveContact(contactRequestDto);
        return isSaved?ResponseEntity.status(HttpStatus.CREATED).body("Request procesed successfully"): ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request processing failed");
    }
}
