-- DB에 있는 멤버정보랑 id, pw가 같으면 -> 성공

-- ** SQL injection (해킹기술)

-- 1) 아래를 DAO에서 실행해서 데이터가 안나오면 실패, 나오면 성공
select * from jan20_sns 
where m_id = 'asdf' and m_id = 'asdf';

-- 2) 아래를 DAO에서 실행해서 데이터가 안나오면 실패
--		나왔을때 DAO에서 if문을 써서 pw검사해서 틀리면 실패, 맞으면 성공 (추천 / 보안코딩측면)
select * from jan20_sns 
where m_id = 'asdf';

-- 3) 회원이 1000명이면 다 가져와야하나?! 비추
select * from JAN20_SNS;
----------------------------------
create table jan20_sns(
	m_id varchar2(10 char) primary key,
	m_pw varchar2(12 char) not null,
	m_name varchar2(10 char) not null,
	m_phone varchar2(11 char) not null,
	m_birthday date not null,
	m_photo varchar2(100 char) not null		-- 파일명
);
-- ㅋ ㅋ.png
-- %2A+%2A.png


select * from jan20_sns;
------------------------------------
create table board(
	b_no number(3) primary key,
	b_writer varchar2(10 char) not null,
	b_when date not null,
	b_text varchar2(200 char) not null
);

create sequence board_seq;
select * from board;
drop table board cascade constraint purge;
drop sequence board_seq;
-------------------------------------
-- 전체 갯수
select count(*) 
from board, JAN20_SNS
where b_writer = m_id; 

-- 검색한거 갯수
select count(*) 
from board, JAN20_SNS
where b_writer = m_id and b_text like '%%' 

-- 전체조회 겸 검색한거에서 4~7번까지(***)
select *
from (
	select rownum as rn, b_no, b_writer, b_when, b_text, m_photo
	from (
		select * 
		from board, JAN20_SNS
		where b_writer = m_id and b_text like '%%' 
		order by b_when desc
	)
)
where rn >= 4 and rn <= 7










