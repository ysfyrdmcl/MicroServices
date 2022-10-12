package org.ysfyrdmcl.rabbitmq.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.ysfyrdmcl.rabbitmq.model.CreateUser;
import org.ysfyrdmcl.repository.entity.UserProfile;
import org.ysfyrdmcl.services.UserService;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreateUserConsumer {
    private  final UserService userService;
    @RabbitListener(queues = "queue-auth-create-user")
    public void createUserMessageConsumer(CreateUser user){
        log.info("User received: {}",user.toString());
        userService.save(UserProfile.builder()
                        .email(user.getEmail())
                        .username(user.getUsername())
                        .authid(user.getAuthid())
                .build());

    }
}
