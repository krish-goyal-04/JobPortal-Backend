package com.example.JobPortal.contact.controller;

import com.example.JobPortal.contact.service.IContactService;
import com.example.JobPortal.dto.ContactRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactController {

    public final IContactService contactService;

    @PostMapping
    public ResponseEntity<String> saveContactMessage(@RequestBody @Valid ContactRequestDto contactRequestDto){
        boolean isSaved = contactService.saveContact(contactRequestDto);
        return isSaved?ResponseEntity.status(HttpStatus.CREATED).body("Request processed successfully"): ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request processing failed");
    }

    @GetMapping
    public ResponseEntity<String> fetchOpenContacts(@RequestParam @Validated @NotBlank(message = "Status cannot be blank") String status){
        return ResponseEntity.ok("These are the contacts with status "+status);

    }
}
