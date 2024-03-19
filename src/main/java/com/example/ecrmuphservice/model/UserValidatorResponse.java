package com.example.ecrmuphservice.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "output")
public class UserValidatorResponse {
    private String errorCode;
    private String errorMessage;
    private UserInfo data;

    public String getErrorCode() {
        return errorCode;
    }

    @XmlElement(name = "errorCode")
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @XmlElement(name = "errorMessage")
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public UserInfo getData() {
        return data;
    }

    @XmlElement(name = "data")
    public void setData(UserInfo data) {
        this.data = data;
    }
}
