package com.nitish.jobapp.impl.interfaces;
import com.nitish.jobapp.Entity.*;


import java.util.List;

public interface CompanyService {
    List<Company> getCompany();
    void createCompany(Company company);
    Company getCompanyById(long id);
    boolean updateCompanyByID(Company company, long id);
    boolean deleteCompanyById(long id);

}
