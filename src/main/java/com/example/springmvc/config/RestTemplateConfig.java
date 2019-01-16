package com.example.springmvc.config;

import com.example.springmvc.intercepter.HttpLogUtil;
import com.example.springmvc.intercepter.RestTemplateInterceptor;
import com.google.common.collect.Lists;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
public class RestTemplateConfig {

    @Autowired
    HttpLogUtil httpLogUtil;

    @Bean
    public HttpClient httpClient() {
        return HttpClients.custom()
                .useSystemProperties()
                .setMaxConnPerRoute(30)
                .setMaxConnTotal(50)
                .build();
    }

    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory(HttpClient httpClient) {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        clientHttpRequestFactory.setConnectionRequestTimeout(60000);
        clientHttpRequestFactory.setConnectTimeout(10000);
        clientHttpRequestFactory.setReadTimeout(500000);
        return clientHttpRequestFactory;
    }

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory clientHttpRequestFactory) {
        RestTemplate restTemplate = new RestTemplateBuilder().requestFactory(() -> new BufferingClientHttpRequestFactory(clientHttpRequestFactory)).build();
        List<ClientHttpRequestInterceptor> interceptors = Lists.newArrayList(new RestTemplateInterceptor(httpLogUtil));
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }
}
