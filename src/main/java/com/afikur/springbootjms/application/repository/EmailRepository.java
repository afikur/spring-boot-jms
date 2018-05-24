package com.afikur.springbootjms.application.repository;

import com.afikur.springbootjms.application.model.Email;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmailRepository extends MongoRepository<Email, String> {
}
