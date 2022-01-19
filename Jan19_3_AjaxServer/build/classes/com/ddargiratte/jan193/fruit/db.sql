create table fruit(
	f_name varchar2(10 char) primary key,
	f_price number(5) not null

);
drop table fruit;

insert into fruit values('딸기', 4000);
insert into fruit values('수박', 14000);
insert into fruit values('사과', 2000);
insert into fruit values('적포도', 5000);

select * from fruit;