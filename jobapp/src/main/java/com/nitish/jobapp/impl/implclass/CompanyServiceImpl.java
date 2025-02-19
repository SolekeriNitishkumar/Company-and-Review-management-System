package com.nitish.jobapp.impl.implclass;

import com.nitish.jobapp.Entity.Company;
import com.nitish.jobapp.DataLayerRepository.*;
import com.nitish.jobapp.impl.interfaces.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getCompany() {
        return companyRepository.findAll();
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateCompanyByID(Company company, long id) {
        Optional<Company> opcompany= companyRepository.findById(id);
        if(opcompany.isPresent())
        {
            Company com  = opcompany.get();
            com.setName(company.getName());
            com.setDescription(company.getDescription());
            com.setJobid(company.getJobid());
            companyRepository.save(com);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCompanyById(long id) {
        try {
            companyRepository.deleteById(id);
            return true;
        } catch (Exception e) {
           return false;
        }
    }
}
