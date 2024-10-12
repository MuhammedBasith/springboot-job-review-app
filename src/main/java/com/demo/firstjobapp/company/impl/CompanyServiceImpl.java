package com.demo.firstjobapp.company.impl;

import com.demo.firstjobapp.company.Company;
import com.demo.firstjobapp.company.CompanyRepository;
import com.demo.firstjobapp.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public void addACompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Company updateCompany(Company updatedCompany, Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);

        if(companyOptional.isPresent()){
            Company company = companyOptional.get();
            company.setDescription(updatedCompany.getDescription());
            company.setName(updatedCompany.getName());
            company.setJobs(updatedCompany.getJobs());

            companyRepository.save(company);
            return company;
        }

        return null;
    }

    @Override
    public boolean deleteCompanyById(Long id){
        if(companyRepository.existsById(id)){
            companyRepository.deleteById(id);
            return true;
        }else {
            return false;
        }

    }

    @Override
    public Company getACompany(Long id) {
        return companyRepository.findById(id).get();
    }

}
