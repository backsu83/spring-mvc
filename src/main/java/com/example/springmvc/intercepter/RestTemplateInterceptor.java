package com.example.springmvc.intercepter;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.time.LocalTime;

public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {

    private HttpLogUtil httpLogUtil;

    public RestTemplateInterceptor(HttpLogUtil httpLogUtil) {
        this.httpLogUtil = httpLogUtil;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        long startAt = LocalTime.now().toNanoOfDay();
//        httpLogUtil.traceClientRequest(request, body);
        ClientHttpResponse response = execution.execute(request, body);
//        httpLogUtil.traceClientResponse(request, response);
        httpLogUtil.traceClientApi(request, body, response , startAt);
        return response;
    }
}
