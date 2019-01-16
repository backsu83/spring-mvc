package com.example.springmvc.dao.database;

import com.example.springmvc.dto.Odds;

import java.util.List;

public interface OddsRepositoryCustom {

    List<Odds> selectOdds();

}
