package org.ankanchanda.jobapplication.company;

import java.util.List;

import org.ankanchanda.jobapplication.job.Job;

public interface CompanyService {
    List<Company> findAll();

    Company findCompanyById(Long id);

    void createCompany(Company company);

    boolean deleteCompanyById(Long id);

    boolean updateCompany(Long id, Company company);

    List<Job> getJobsByCompanyId(Long id);
}
