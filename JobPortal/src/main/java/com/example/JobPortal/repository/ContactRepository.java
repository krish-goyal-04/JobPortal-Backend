package com.example.JobPortal.repository;

import com.example.JobPortal.dto.ContactRequestDto;
import com.example.JobPortal.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {


}
