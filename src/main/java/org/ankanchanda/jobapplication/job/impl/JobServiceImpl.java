package org.ankanchanda.jobapplication.job.impl;

import java.util.ArrayList;
import java.util.List;

import org.ankanchanda.jobapplication.job.Job;
import org.ankanchanda.jobapplication.job.JobService;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService {
    private List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public Job findJobById(Long id) {
        return jobs.stream().filter(job -> job.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public boolean deleteJob(Long id) {
        return jobs.removeIf(job -> job.getId().equals(id));
    }

    @Override
    public boolean updateJob(Long id, Job job) {
        return jobs.stream().filter(j -> j.getId().equals(id)).findFirst().map(j -> {
            j.setTitle(job.getTitle());
            j.setDescription(job.getDescription());
            j.setLocation(job.getLocation());
            j.setMinimumSalary(job.getMinimumSalary());
            j.setMaximumSalary(job.getMaximumSalary());
            return true;
        }).orElse(false);
    }
}
