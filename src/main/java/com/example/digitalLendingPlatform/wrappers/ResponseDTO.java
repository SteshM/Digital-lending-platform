package com.example.digitalLendingPlatform.wrappers;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseDTO {
    private int statusCode;
    private String statusMessage;
    private Object result;
}
