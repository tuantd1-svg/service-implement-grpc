package com.example.ecrmuphservice.repository;

import com.example.ecrmuphservice.model.UserValidatorRequest;
import com.example.ecrmuphservice.model.UserValidatorResponse;

public interface EcrmService {

    UserValidatorResponse verifyUser(UserValidatorRequest userValidatorRequest);
}
