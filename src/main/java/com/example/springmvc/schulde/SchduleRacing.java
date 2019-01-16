package com.example.springmvc.schulde;

import com.example.springmvc.service.DisplayBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class SchduleRacing {

    @Autowired
    private DisplayBoardService racing;

    @Scheduled(cron = "0 0 9 * * *")
    public void schduleAddOdds() {
        racing.addOddsForBatch(LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE));
    }
}
