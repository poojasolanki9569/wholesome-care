package com.stackroute.questionnaireservice.service;

import com.stackroute.questionnaireservice.model.ScoreBeltsWithID;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
@Service
public class RabbitMQSender {
    private RabbitTemplate rabbitTemplate;
    @Autowired
    public RabbitMQSender(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }
    @Value("${spring.rabbitmq.exchange}")
    private String exchange;
    @Value("${spring.rabbitmq.routingkey}")
    private String routingKey;
    public void send(ScoreBeltsWithID scoreBeltsWithID){
        rabbitTemplate.convertAndSend(exchange, routingKey, scoreBeltsWithID);
        System.out.println(scoreBeltsWithID);
    }
}

