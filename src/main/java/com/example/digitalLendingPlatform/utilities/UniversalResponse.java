package com.example.digitalLendingPlatform.utilities;

import com.example.digitalLendingPlatform.configs.SystemConfigs;
import com.example.digitalLendingPlatform.wrappers.ResponseDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@RequiredArgsConstructor
public class UniversalResponse {
private final SystemConfigs systemConfigs;
    public ResponseDTO successResponse(String statusMessage, Object result) {
        var response = new ResponseDTO();
        response.setStatusCode(systemConfigs.getSuccessStatusCode());
        response.setStatusMessage(statusMessage);
        response.setResult(result);
        return response;
    }

    public ResponseDTO failedResponse(int statusCode, String statusMessage, Object result) {
        var response = new ResponseDTO();
        response.setStatusCode(statusCode);
        response.setStatusMessage(statusMessage);
        response.setResult(result);

        return response;
    }
}
