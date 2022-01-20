---------------------------------------------
create table login(
	l_id varchar2(20 char) primary key,
	l_pw varchar2(20 char) not null,
	l_pwr varchar2(20 char) not null,
	l_name varchar2(10 char) not null,
	l_phoneNumber number(11) not null,
	l_birthday date not null,
	l_gender varchar2(10 char) not null,
	l_photo varchar2(100 char) not null	
);
drop table login;
select * from login;
---------------------------------------------
