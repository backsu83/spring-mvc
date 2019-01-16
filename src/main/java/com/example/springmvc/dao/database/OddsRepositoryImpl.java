package com.example.springmvc.dao.database;

import com.example.springmvc.dto.Odds;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.springmvc.dto.QOdds.odds;

@Repository
public class OddsRepositoryImpl extends QuerydslRepositorySupport implements OddsRepositoryCustom {

    private final JPAQueryFactory query;

    public OddsRepositoryImpl(JPAQueryFactory queryFactory) {
        super(Odds.class);
        this.query = queryFactory;
    }

    @Override
    public List<Odds> selectOdds() {
        return query.selectFrom(odds).fetch();
    }
}
