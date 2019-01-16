
create table if not exists Odds
(
   id integer auto_increment,
   rcno integer not null,
   rcdate integer not null,
   rate integer not null,
   meet varchar(100) not null,
   pool varchar(100) not null,
   chulno3 integer not null,
   chulno2 integer not null,
   chulno1 integer not null,
   primary key (id)
);

/*
    private int id;
    private int rcno;
    private int rcdate;
    private double odds;
    private String meet;
    private String pool;
    private int chulno3;
    private int chulno2;
    private int chulno1;
 */

-- insert into Odds values(1 , 1, 20190105 , 10 , '서울' , '연승식' , 1 , 2 , 3 );
-- insert into Odds values(2 , 1, 20190105 , 12 , '부산' , '연승식' , 1 , 2 , 3 );
-- insert into Odds values(3 , 1, 20190105 , 100 , '경남' , '복승식' , 1 , 2 , 3 );