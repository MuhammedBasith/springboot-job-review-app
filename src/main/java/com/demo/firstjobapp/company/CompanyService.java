package com.demo.firstjobapp.company;

import org.springframework.stereotype.Service;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    void addACompany(Company company);
    Company updateCompany(Company updatedCompany, Long id);
    boolean deleteCompanyById(Long id);
    Company getACompany(Long id);

}
