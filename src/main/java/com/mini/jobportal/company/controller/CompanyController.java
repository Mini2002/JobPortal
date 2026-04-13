package com.mini.jobportal.company.controller;

import com.mini.jobportal.dto.CompanyDto;
import com.mini.jobportal.company.service.ICompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/companies")
//@CrossOrigin(origins = {"http://localhost:5173/"})
public class CompanyController {

    private final ICompanyService companyService;

    @GetMapping(version = "1.0")
    public ResponseEntity<List<CompanyDto>> getAllCompanies() {
        List<CompanyDto> companyList = companyService.getAllCompanies();
        return ResponseEntity.ok().body(companyList);
//        return ResponseEntity.ok().body("List of all companies is ");
    }
}
