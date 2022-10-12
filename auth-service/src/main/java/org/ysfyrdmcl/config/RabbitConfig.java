package org.ysfyrdmcl.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    private String exchangeNameAuth = "exchange-auth";
    private String bindingKeyAuth = "key-auth";
    private String queueNameAuth="queue-auth-create-user";
    @Bean
    DirectExchange exchangeAuth(){
        return new DirectExchange(exchangeNameAuth);
    }
    @Bean
    Queue queueAuthCreateUser(){
        return new Queue(queueNameAuth);
    }
    @Bean
    public Binding bindingAuthCreateUser(final Queue queueAuthCreateUser, final DirectExchange exchangeAuth){
        return BindingBuilder.bind(queueAuthCreateUser).to(exchangeAuth).with(bindingKeyAuth);
    }
}
