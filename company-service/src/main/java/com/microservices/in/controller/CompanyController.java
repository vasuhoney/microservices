package com.microservices.in.controller;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.in.model.Company;
import com.microservices.in.service.CompanyService;

@RestController
@RequestMapping("/company")

public class CompanyController {

	private static final Logger log = LoggerFactory.getLogger(CompanyController.class);

	@Autowired
	private CompanyService companyService;

	@PostMapping("/saveCompany")
	public Company saveCompany(@RequestBody Company company) {
		log.info("saving company details: {}" , company.getCompanyId());

		return companyService.companySave(company);

	}

	@GetMapping("/{companyId}")
	public Optional<Company> getCompanyId(@PathVariable("companyId") Long companyId) {
		log.info("getting company details based on id: {}" , companyId);
		return companyService.getCompanyId(companyId);
	}
}
