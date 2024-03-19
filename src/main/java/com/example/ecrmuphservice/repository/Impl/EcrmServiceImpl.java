package com.example.ecrmuphservice.repository.Impl;

import com.example.commonapi.utils.XmlUtils;
import com.example.ecrmuphservice.enumable.ErrorCodeCore;
import com.example.ecrmuphservice.model.UserValidatorRequest;
import com.example.ecrmuphservice.model.UserValidatorResponse;
import com.example.ecrmuphservice.repository.EcrmService;
import com.example.ecrmuphservice.utils.StoreProcedure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EcrmServiceImpl implements EcrmService {


    @Autowired
    private StoreProcedure storeProcedure;

    @Override
    public UserValidatorResponse verifyUser(UserValidatorRequest userValidatorRequest) {
        String output = "";
        UserValidatorResponse userValidatorResponse = null;
        try {
            String xmlInput = XmlUtils.toXml(userValidatorRequest);
            output = storeProcedure.callStore("HDBO_MUADEE_SERVICE.VALIDATE_USER", xmlInput);
            userValidatorResponse = XmlUtils.fromXml(output, UserValidatorResponse.class);

        } catch (Exception e) {
            userValidatorResponse.setErrorCode(ErrorCodeCore.SYSTEM_ERROR.getCode());
            userValidatorResponse.setErrorMessage(ErrorCodeCore.SYSTEM_ERROR.getMessage());
        }
        return userValidatorResponse;
    }

}
