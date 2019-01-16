package com.example.springmvc.schulde;

import com.example.springmvc.service.DisplayBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchduleRacing {

    @Autowired
    private DisplayBoardService board;

    @Scheduled(cron = "0 0 9 * * *")
    public void schduleAddOdds() {
        board.addOddsForBatch("20190105");
    }
}
