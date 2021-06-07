package com.microservices.in.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.microservices.in.constants.MQConstants;
import com.microservices.in.service.RabbitMQListener;

@Configuration
public class RabbitMQConfig {
	
	@Bean
	public Queue queue() {
		return new Queue(MQConstants.QUEUE, false);
	}

	// create MessageListenerContainer using default connection factory
	@Bean
	MessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory) {
		SimpleMessageListenerContainer simpleMessage = new SimpleMessageListenerContainer();
		simpleMessage.setConnectionFactory(connectionFactory);
		simpleMessage.setQueues(queue());
		simpleMessage.setMessageListener(new RabbitMQListener());
		return simpleMessage;

	}

}
