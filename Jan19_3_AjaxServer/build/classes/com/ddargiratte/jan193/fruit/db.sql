create table fruit(
	f_name varchar2(10 char) primary key,
	f_price number(5) not null

);
drop table fruit;

insert into fruit values('����', 4000);
insert into fruit values('����', 14000);
insert into fruit values('���', 2000);
insert into fruit values('������', 5000);

select * from fruit;