package com.afikur.springbootjms.application.Consumer;

import com.afikur.springbootjms.application.model.Email;
import com.afikur.springbootjms.application.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {
    @Autowired
    private EmailRepository emailRepository;

    @JmsListener(destination = "Emails", concurrency = "3-10")
    public void onMessage(@Payload Email email) {
        System.out.println("Received: " + email);
        emailRepository.save(email);
    }
}
