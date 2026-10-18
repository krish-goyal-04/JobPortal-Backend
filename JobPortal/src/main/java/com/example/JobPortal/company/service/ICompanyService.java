package com.example.JobPortal.company.service;

import com.example.JobPortal.dto.CompanyDto;
import com.example.JobPortal.entity.Company;

import java.util.List;

public interface ICompanyService {
    List<CompanyDto> getAllCompanies();
}
