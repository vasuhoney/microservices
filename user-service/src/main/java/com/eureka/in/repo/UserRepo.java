package com.eureka.in.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eureka.in.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	

	User findByUserId(long userId);

	

}
