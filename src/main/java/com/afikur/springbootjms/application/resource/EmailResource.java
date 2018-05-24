package com.afikur.springbootjms.application.resource;

import com.afikur.springbootjms.application.producer.EmailProducer;
import com.afikur.springbootjms.application.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailResource {
    @Autowired
    EmailProducer emailProducer;

    @PostMapping(path = "/send")
    public void send(@RequestBody Email email) {
        emailProducer.sendEmail(email, email.getPriority(), 300000);
    }
}
