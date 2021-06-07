package com.eureka.in.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eureka.in.model.User;
import com.eureka.in.service.UserService;
import com.eureka.in.vo.RestTemplateVo;

@RestController
@RequestMapping("/user")
public class UserController {

	private Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@PostMapping("/userSave")
	public User saveUser(@RequestBody User user) {
		log.info("saving user details :{} ", user.getUserId());
		return userService.userSave(user);

	}

	@GetMapping("/{id}")
	public RestTemplateVo getUserDetails(@PathVariable("id") Long userId) {
		log.info("getting user details with department details based on id: {}", userId);
		return userService.getUserWithCompany(userId);

	}

	@GetMapping(value = "/producer")
	public String producer(@RequestParam("userName") String userName, @RequestParam("userId") Long userId,
			@RequestParam("userAddress") String userAddress) {
		User user = new User();
		user.setUserId(userId);
		user.setUserName(userName);
        user.setUserAddress(userAddress);
		userService.send(user);

		return "Message sent to the RabbitMQ Successfully";
	}

}
