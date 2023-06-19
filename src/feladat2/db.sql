create database ingatlan_db;

use ingatlan_db;

create table ingatlanok (
tulajdonos text,
helyrajzi_szam text unique ,
alapterulet int not null,
becsult_ertek int 
);

insert into ingatlanok values("Magyar Endre","125/2",170,75000000);
insert into ingatlanok values("Kiss Lilla","3181/1",110,45000000);
insert into ingatlanok values("Tóth Eszter","11055",80,32000000);
insert into ingatlanok values("Fekete Benedek","1101/1",100,40000000);
insert into ingatlanok values("Nagy Andrea","2345",135,59000000);
