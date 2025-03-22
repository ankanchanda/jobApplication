package org.ankanchanda.jobapplication.company.impl;

import org.ankanchanda.jobapplication.company.CompanyRepository;
import org.ankanchanda.jobapplication.company.CompanyService;
import org.ankanchanda.jobapplication.job.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.ankanchanda.jobapplication.company.Company;

@Service
public class CompanyServiceImpl implements CompanyService{
    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company findCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        if(companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        } 
        return false;
    }

    @Override
    public boolean updateCompany(Long id, Company updatedCompany) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if(companyOptional.isPresent()){
            Company company = companyOptional.get();
            company.setName(updatedCompany.getName());
            company.setDescription(updatedCompany.getDescription());
            companyRepository.save(company);
            return true;
        }
        return false;
    }

    @Override
    public List<Job> getJobsByCompanyId(Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if(companyOptional.isPresent()){
            Company company = companyOptional.get();
            return company.getJobs();
        }
        return null;
    }
}
