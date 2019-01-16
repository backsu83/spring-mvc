package com.example.springmvc.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor
public class Odds {

    @Id @GeneratedValue
    private int id;
    private int rcno;
    private int rcdate;
    private double rate;
    private String meet;
    private String pool;
    private int chulno3;
    private int chulno2;
    private int chulno1;

    @Builder
    public Odds(int rcno, int rcdate, double rate, String meet, String pool , int chulno3, int chulno2, int chulno1) {
        this.rcno = rcno;
        this.rcdate = rcdate;
        this.rate = rate;
        this.meet = meet;
        this.pool = pool;
        this.chulno3 = chulno3;
        this.chulno2 = chulno2;
        this.chulno1 = chulno1;
    }
}
