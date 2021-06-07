package com.microservices.in.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.microservices.in.model.Company;

@Service
public interface CompanyService {
	Company companySave(Company company);

	Optional<Company> getCompanyId(Long companyId);

}
