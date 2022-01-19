create table jan18_apple(
	a_location varchar2(10 char) primary key,
	a_color varchar2(10 char) not null,
	a_flavor varchar2(10 char) not null,
	a_price number(5) not null,
	a_introduce varchar2(100 char) not null
);

insert into jan18_apple values('ÃæÁÖ', '»¡°­', '´Ü¸À', 4000, 'ÃæÁÖ»ç°ú!!!!');
insert into jan18_apple values('ÃæÁÖ1', '»¡°­', '´Ü¸À', 4000, 'ÃæÁÖ»ç°ú!!!!');
insert into jan18_apple values('ÃæÁÖ2', '»¡°­', '´Ü¸À', 4000, 'ÃæÁÖ»ç°ú!!!!');
insert into jan18_apple values('ÃæÁÖ3', '»¡°­', '´Ü¸À', 4000, 'ÃæÁÖ»ç°ú!!!!');
insert into jan18_apple values('ÃæÁÖ4', '»¡°­', '´Ü¸À', 4000, 'ÃæÁÖ»ç°ú!!!!');
select * from JAN18_APPLE;