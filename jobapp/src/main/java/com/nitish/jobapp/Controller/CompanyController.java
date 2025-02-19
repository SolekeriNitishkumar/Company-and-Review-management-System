package com.nitish.jobapp.Controller;
import com.nitish.jobapp.Entity.Company;
import com.nitish.jobapp.impl.interfaces.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/companies")
public class CompanyController {

    CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> GetCompany()
    {
        return new ResponseEntity<>(companyService.getCompany(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> postCompay(@RequestBody Company company)
    {
        companyService.createCompany(company);
        return new ResponseEntity<>("Company is added succesfully",HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable long id)
    {
        return new ResponseEntity<>(companyService.getCompanyById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompanyById(@RequestBody Company company, @PathVariable long id)
    {
        boolean updated = companyService.updateCompanyByID(company,id);
        if (updated)
        {
            return new ResponseEntity<>("Company updated succesufully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Company not found",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable long id)
    {
        boolean deleted = companyService.deleteCompanyById(id);
        if (deleted)
        {
            return new ResponseEntity<>("Company deleted succesufully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Company not found",HttpStatus.NOT_FOUND);

    }

}
