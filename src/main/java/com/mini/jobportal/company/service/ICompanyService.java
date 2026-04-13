package com.mini.jobportal.company.service;

import com.mini.jobportal.dto.CompanyDto;
import com.mini.jobportal.entity.Company;

import java.util.List;

public interface ICompanyService {

    List<CompanyDto> getAllCompanies();
}
