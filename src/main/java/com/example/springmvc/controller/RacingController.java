package com.example.springmvc.controller;

import com.example.springmvc.dao.api.RacingResponse;
import com.example.springmvc.service.DisplayBoardService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Slf4j
@RestController
@AllArgsConstructor
public class RacingController {

    @Autowired
    private DisplayBoardService service;

    @RequestMapping(value = "/" , method = GET)
    public RacingResponse get(@RequestParam String date) {
        log.info("date {}" , date);
        return service.getOdds(date);
    }

    @RequestMapping(value = "/batch" , method = GET)
    public void batch(@RequestParam String date) {
        log.info("date {}" , date);
        service.addOddsForBatch(date);
    }
}
