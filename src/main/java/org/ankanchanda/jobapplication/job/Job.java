package org.ankanchanda.jobapplication.job;

public class Job {
    Long id;
    String title;
    String description;
    String location;
    Double minimumSalary;
    Double maximumSalary;

    public Job() {
    }

    public Job(Long id, String title, String description, String location, Double minimumSalary, Double maximumSalary) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.minimumSalary = minimumSalary;
        this.maximumSalary = maximumSalary;
    }

    public Job(String title, String description, String location, Double minimumSalary, Double maximumSalary) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.minimumSalary = minimumSalary;
        this.maximumSalary = maximumSalary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getMinimumSalary() {
        return minimumSalary;
    }

    public void setMinimumSalary(Double minimumSalary) {
        this.minimumSalary = minimumSalary;
    }

    public Double getMaximumSalary() {
        return maximumSalary;
    }

    public void setMaximumSalary(Double maximumSalary) {
        this.maximumSalary = maximumSalary;
    }

}
