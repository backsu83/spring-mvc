package com.example.springmvc.service;

import com.example.springmvc.dao.api.Item;
import com.example.springmvc.dao.api.Items;
import com.example.springmvc.dao.api.RacingApi;
import com.example.springmvc.dao.api.RacingResponse;
import com.example.springmvc.dao.database.OddsRepository;
import com.example.springmvc.dto.Odds;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DisplayBoardService {

    @Autowired
    private RacingApi racingApi;

    @Autowired
    private OddsRepository oddsRepo;

    public RacingResponse getOdds(String date) {
        RacingResponse kraResponse = racingApi.getOddsByAll(date);
        log.info(kraResponse.toString());
        return kraResponse;
    }

    public void addOddsForBatch(String date) {
        log.info("start add odds date ... {}" , date);
        Items items = racingApi.getOddsByAll(date).getResponse().getBody().getItems();
        for (Item item : items.getItem()) {
            oddsRepo.save(Odds.builder()
                    .chulno3(item.getChulno3())
                    .chulno2(item.getChulno2())
                    .chulno1(item.getChulno1())
                    .meet(item.getMeet())
                    .rate(item.getOdds())
                    .pool(item.getPool())
                    .rcdate(item.getRcdate())
                    .rcno(item.getRcno())
                    .build());
        }
    }
}
