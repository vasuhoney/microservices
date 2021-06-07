package com.eureka.in.service;

import org.springframework.stereotype.Service;
import com.eureka.in.model.User;
import com.eureka.in.vo.RestTemplateVo;

@Service
public interface UserService {
	
	
	
	User userSave(User user);

	RestTemplateVo getUserWithCompany(Long userId);

	void send(User user);
	

}
