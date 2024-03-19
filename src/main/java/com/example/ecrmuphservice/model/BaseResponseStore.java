package com.example.ecrmuphservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor
@NoArgsConstructor
public class BaseResponseStore {
    private String errorCode;
    private String errorMessage;
}
