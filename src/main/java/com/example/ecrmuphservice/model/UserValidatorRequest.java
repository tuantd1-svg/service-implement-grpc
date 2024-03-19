package com.example.ecrmuphservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
@XmlRootElement(name = "input")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class UserValidatorRequest {
    private String clientNumber;
    private String acctType;

    private String partnerId;
}
