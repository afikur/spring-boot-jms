package com.afikur.springbootjms.application.producer;

import com.afikur.springbootjms.application.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Service;

import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;

@Service
public class EmailProducer {

    @Autowired
    @Qualifier("cachingConnectionFactory")
    ConnectionFactory cachingConnectionFactory;

    @Autowired
    MessageConverter messageConverter;

    public void sendEmail(Email email,
                          int priority,
                          int timeToLive) {

        JmsTemplate template = new JmsTemplate(cachingConnectionFactory);
        template.setMessageConverter(messageConverter);
        template.setExplicitQosEnabled(true);
        template.setPriority(priority);
        template.setTimeToLive(timeToLive);
        template.convertAndSend("Emails", email);
    }
}