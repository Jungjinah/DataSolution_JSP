Drop table blade;
create table blade(
	b_location varchar2(10 char) primary key,
	b_name varchar2(10 char) not null,
	b_color varchar2(10 char) not null,
	b_gender varchar2(10 char) not null,
	b_person number(2) not null
);

insert into blade values('투니버스', '카마도 탄지로', '붉은', '남자', 1);
insert into blade values('웨이브', '카마도 네츠코', '분홍', '여자', 2);
insert into blade values('유튜브', '아가츠마 젠이츠', '노랑', '남자', 3);
insert into blade values('넷플릭스', '하시비라 이노스케', '돼지', '남자', 4);
select * from blade;