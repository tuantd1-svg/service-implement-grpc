package com.example.ecrmuphservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;



@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    private String userName;

    public String getUserName() {
        return userName;
    }

    @XmlElement(name = "userName")
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
