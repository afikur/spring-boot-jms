package com.afikur.springbootjms.application.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@ToString(exclude = "id")
@NoArgsConstructor
@Document
public class Email {
    @Id
    private String id;
    private String emailAddress;
    private String name;
    private String message;
    private int priority;

    public Email(String emailAddress, String name, String message) {
        this.emailAddress = emailAddress;
        this.name = name;
        this.message = message;
    }
}
