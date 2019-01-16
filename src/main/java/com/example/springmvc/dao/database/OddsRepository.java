package com.example.springmvc.dao.database;

import com.example.springmvc.dto.Odds;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OddsRepository extends JpaRepository<Odds, Long>, OddsRepositoryCustom {
}
