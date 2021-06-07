package com.microservices.in.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.in.model.Company;

@Repository
	public interface CompanyRepo extends JpaRepository<Company, Integer> {

		Optional<Company> findByCompanyId(Long companyId);

}
