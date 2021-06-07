package com.microservices.in.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microservices.in.model.Company;
import com.microservices.in.repo.CompanyRepo;
import com.microservices.in.service.CompanyService;
@Component
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyRepo companyRepo;

	@Override
	public Company companySave(Company company) {
		return companyRepo.save(company);
	}

	@Override
	public Optional<Company> getCompanyId(Long companyId) {
		Optional<Company> op = companyRepo.findByCompanyId(companyId);
		if (op.isPresent())
			return op;
		else {
			return Optional.empty();
		}
	}


}
