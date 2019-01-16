package com.example.springmvc.dao.api.base;

import com.example.springmvc.exception.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;

public class ApiExecutor {
    private ApiExecutor() {}
    public static <R> R execute(ApiExecutable<R> executable) {
        try {
            return executable.execute();
        } catch ( HttpStatusCodeException ex ) {
            //TODO : 2xx 가 아닐때 처리
            throw ex;
        } catch ( RestClientException ex ) {
            throw new ApiException(ex.getMessage());
        }
    }
    public static <R> R getBody(ResponseEntity<R> responseEntity, String hostName) {
        if ( !responseEntity.getStatusCode().is2xxSuccessful() ) {
            throw new ApiException(hostName + " API 결과가 " + responseEntity.getStatusCodeValue() + " 입니다.");
        }
        return responseEntity.getBody();
    }
}
