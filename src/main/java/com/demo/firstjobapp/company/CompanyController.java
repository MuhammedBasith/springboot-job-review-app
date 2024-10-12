package com.demo.firstjobapp.company;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping
    public List<Company> getAllCompanies(){
        return companyService.getAllCompanies();
    }

    @PostMapping
    public Company addCompany(@RequestBody Company company){
        companyService.addACompany(company);
        return company;
    }

    @PutMapping
    public Company updateCompany(@RequestBody Company company, @PathVariable Long id){
        return companyService.updateCompany(company, id);
    }

    @DeleteMapping
    public boolean deleteCompany(@PathVariable Long id){
        return companyService.deleteCompanyById(id);
    }

    @GetMapping
    public Company getACompany(@PathVariable Long id){
        return companyService.getACompany(id);
    }
}
