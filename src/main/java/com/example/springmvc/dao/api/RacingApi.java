package com.example.springmvc.dao.api;

import com.example.springmvc.dao.api.base.ApiClient;
import com.example.springmvc.dao.api.base.ApiExecutor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@ApiClient
@NoArgsConstructor
public class RacingApi {

    private String API_HOST;
    private String SERVICE_KEY;
    private RestTemplate restTemplate;

    @Autowired
    public RacingApi(
            @Value("${apis.content.host}") String apiHost,
            @Value("${apis.content.serviceKey}") String serviceKey,
            RestTemplate restTemplate) {
        this.API_HOST = apiHost;
        this.SERVICE_KEY = serviceKey;
        this.restTemplate = restTemplate;
    }

    public RacingResponse getOddsByAll(String date) {

        String url = "/service/api160/getOpenDataList";
        MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
        paramMap.add("ServiceKey", SERVICE_KEY);
        paramMap.add("rc_date", date);
        paramMap.add("pageNo", "1");
        paramMap.add("numOfRows", "10");

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(API_HOST + url);
        URI uri = builder.queryParams(paramMap).build().encode().toUri();
        ParameterizedTypeReference responseType = new ParameterizedTypeReference<RacingResponse>() {};

        ResponseEntity<RacingResponse> responseEntityData = ApiExecutor.execute(() -> restTemplate.exchange(uri, HttpMethod.GET, null,responseType));
        return ApiExecutor.getBody(responseEntityData, this.API_HOST);
    }
}
