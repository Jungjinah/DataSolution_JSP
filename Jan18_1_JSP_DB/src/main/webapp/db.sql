Drop table blade;
create table blade(
	b_location varchar2(10 char) primary key,
	b_name varchar2(10 char) not null,
	b_color varchar2(10 char) not null,
	b_gender varchar2(10 char) not null,
	b_person number(2) not null
);

insert into blade values('���Ϲ���', 'ī���� ź����', '����', '����', 1);
insert into blade values('���̺�', 'ī���� ������', '��ȫ', '����', 2);
insert into blade values('��Ʃ��', '�ư����� ������', '���', '����', 3);
insert into blade values('���ø���', '�Ͻú�� �̳뽺��', '����', '����', 4);
select * from blade;