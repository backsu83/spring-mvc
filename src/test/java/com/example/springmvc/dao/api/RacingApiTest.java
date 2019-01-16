package com.example.springmvc.dao.api;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(properties = {"apis.content.host"})
public class RacingApiTest {

    @Value("${apis.content.host}")
    private String API_HOST;

    @Test
    public void testRacingApi() {
        String url = "/service/api5/getOpenDataList";
        MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
        paramMap.add("ServiceKey", "5F45A07FC9FD27FCA72FB4E4A76AD07F8E4B8EEC5C31EE6534E2C5E9AA3062");
        paramMap.add("rc_date", "20190113");
        paramMap.add("pageNo", "1");
        paramMap.add("numOfRows", "50");
        paramMap.add("meet", "3");

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(API_HOST + url);
        URI uri = builder.queryParams(paramMap).build().encode().toUri();
        log.info(API_HOST + uri);

    }
}