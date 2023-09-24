package com.geekster.Job.using.H2.DataBase.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
public class Job {
    @Id
  private Integer jobId;
  private String jobTitle;
  private String jobDescription;
  private  String jobLocation;
    @Min(20000)
  private Double jobSalary;
    @Email
    private String CompanyEmail;
    private String CompanyName;
    private String employerName;

    @Enumerated(value = EnumType.STRING )
    private Type jobType;

    private LocalDate appliedDate;


  public Integer getJobId() {
    return jobId;
  }

  public void setJobId(Integer jobId) {
    this.jobId = jobId;
  }

  public String getJobTitle() {
    return jobTitle;
  }

  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
  }

  public String getJobDescription() {
    return jobDescription;
  }

  public void setJobDescription(String jobDescription) {
    this.jobDescription = jobDescription;
  }

  public String getJobLocation() {
    return jobLocation;
  }

  public void setJobLocation(String jobLocation) {
    this.jobLocation = jobLocation;
  }

  public Double getJobSalary() {
    return jobSalary;
  }

  public void setJobSalary(Double jobSalary) {
    this.jobSalary = jobSalary;
  }

  public String getCompanyEmail() {
    return CompanyEmail;
  }

  public void setCompanyEmail(String companyEmail) {
    CompanyEmail = companyEmail;
  }

  public String getCompanyName() {
    return CompanyName;
  }

  public void setCompanyName(String companyName) {
    CompanyName = companyName;
  }

  public String getEmployerName() {
    return employerName;
  }

  public void setEmployerName(String employerName) {
    this.employerName = employerName;
  }

  public Type getJobType() {
    return jobType;
  }

  public void setJobType(Type jobType) {
    this.jobType = jobType;
  }

  public LocalDate getAppliedDate() {
    return appliedDate;
  }

  public void setAppliedDate(LocalDate appliedDate) {
    this.appliedDate = appliedDate;
  }
}
