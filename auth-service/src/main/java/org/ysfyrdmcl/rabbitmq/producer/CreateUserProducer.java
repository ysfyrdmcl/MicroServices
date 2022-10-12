package org.ysfyrdmcl.rabbitmq.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.ysfyrdmcl.rabbitmq.model.CreateUser;

@Service
@RequiredArgsConstructor
public class CreateUserProducer {
    private final RabbitTemplate rabbitTemplate;
    public void sendCreateUserMessage(CreateUser user){
        rabbitTemplate.convertAndSend("exchange-auth","key-auth",user);
    }
}
