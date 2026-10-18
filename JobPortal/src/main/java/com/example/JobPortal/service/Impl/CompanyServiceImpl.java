package com.example.JobPortal.service.Impl;

import com.example.JobPortal.dto.CompanyDto;
import com.example.JobPortal.entity.Company;
import com.example.JobPortal.repository.CompanyRepository;
import com.example.JobPortal.service.ICompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements ICompanyService {

    private final CompanyRepository companyRepository;
    @Override
    public List<CompanyDto> getAllCompanies(){
        List<Company> companiesList =  companyRepository.findAll();
        return companiesList.stream().map(this::transformToDto).collect(Collectors.toList());
    }
    private CompanyDto transformToDto(Company company){
        return new CompanyDto(company.getId(), company.getName(), company.getLogo(),
                company.getIndustry(), company.getSize(), company.getRating(),
                company.getLocations(), company.getFounded(), company.getDescription(),
                company.getEmployees(), company.getWebsite(), company.getCreatedAt());
    }
}
