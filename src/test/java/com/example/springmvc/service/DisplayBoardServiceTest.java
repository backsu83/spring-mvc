package com.example.springmvc.service;

import com.example.springmvc.dao.database.OddsRepository;
import com.example.springmvc.dto.Odds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DisplayBoardServiceTest {

    @Autowired
    OddsRepository rate;

    @Test
    public void testAddOdds() {
        rate.save(new Odds(1,20190105,10,"서울시","연승식",1,2,3));
    }

    @Test
    public void testLocalDate() {
        System.out.println(LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE));
    }
}