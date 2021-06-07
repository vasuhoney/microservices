package com.eureka.in.serviceimpl;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.eureka.in.model.User;
import com.eureka.in.repo.UserRepo;
import com.eureka.in.service.UserService;
import com.eureka.in.vo.Company;
import com.eureka.in.vo.RestTemplateVo;

@Component
public class UserServiceImpl implements UserService {
	
	public static final String EXCHANGE = "Topic_Exchange";
	public static final String ROUTING_KEY = "Routing_key";

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	



	@Override
	public User userSave(User user) {

		return userRepo.save(user);
	}

	@Override
	public RestTemplateVo getUserWithCompany(Long userId) {
		RestTemplateVo vo = new RestTemplateVo();
		User user = userRepo.findByUserId(userId);
		Company company = restTemplate.getForObject("http://COMPANY-SERVICE/company/" + user.getCompanyId(), Company.class);
		vo.setUser(user);
		vo.setCompany(company);
		return vo;


	}

	@Override
	public void send(User user) {
		rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, user);
		System.out.println("Sending message : " + user);
		
	}

}
