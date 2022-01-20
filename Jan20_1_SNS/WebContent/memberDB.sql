-- DB�� �ִ� ��������� id, pw�� ������ -> ����

-- ** SQL injection (��ŷ���)

-- 1) �Ʒ��� DAO���� �����ؼ� �����Ͱ� �ȳ����� ����, ������ ����
select * from jan20_sns 
where m_id = 'asdf' and m_id = 'asdf';

-- 2) �Ʒ��� DAO���� �����ؼ� �����Ͱ� �ȳ����� ����
--		�������� DAO���� if���� �Ἥ pw�˻��ؼ� Ʋ���� ����, ������ ���� (��õ / �����ڵ�����)
select * from jan20_sns 
where m_id = 'asdf';

-- 3) ȸ���� 1000���̸� �� �����;��ϳ�?! ����
select * from JAN20_SNS;
----------------------------------
create table jan20_sns(
	m_id varchar2(10 char) primary key,
	m_pw varchar2(12 char) not null,
	m_name varchar2(10 char) not null,
	m_phone varchar2(11 char) not null,
	m_birthday date not null,
	m_photo varchar2(100 char) not null		-- ���ϸ�
);
-- �� ��.png
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
-- ��ü ����
select count(*) 
from board, JAN20_SNS
where b_writer = m_id; 

-- �˻��Ѱ� ����
select count(*) 
from board, JAN20_SNS
where b_writer = m_id and b_text like '%%' 

-- ��ü��ȸ �� �˻��Ѱſ��� 4~7������(***)
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










