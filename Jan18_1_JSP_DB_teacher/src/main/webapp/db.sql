create table jan18_apple(
	a_location varchar2(10 char) primary key,
	a_color varchar2(10 char) not null,
	a_flavor varchar2(10 char) not null,
	a_price number(5) not null,
	a_introduce varchar2(100 char) not null
);

insert into jan18_apple values('����', '����', '�ܸ�', 4000, '���ֻ��!!!!');
insert into jan18_apple values('����1', '����', '�ܸ�', 4000, '���ֻ��!!!!');
insert into jan18_apple values('����2', '����', '�ܸ�', 4000, '���ֻ��!!!!');
insert into jan18_apple values('����3', '����', '�ܸ�', 4000, '���ֻ��!!!!');
insert into jan18_apple values('����4', '����', '�ܸ�', 4000, '���ֻ��!!!!');
select * from JAN18_APPLE;