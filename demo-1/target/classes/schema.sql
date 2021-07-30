

create table book (
book_id  integer primary key,
book_name varchar2(100),
author varchar2(100),
published_date date
);

CREATE SEQUENCE book_seq START WITH 1;

insert into book (book_id, book_name, author, published_date) values (book_seq.NEXTVAL, 'KARMA' , 'Sadhguru' , TO_DATE('13.09.2007','DD.MM.YYYY'));
insert into book (book_id, book_name, author, published_date) values (book_seq.NEXTVAL, 'KARMA1' , 'Sadhguru1' , TO_DATE('13.09.2007','DD.MM.YYYY'));
insert into book (book_id, book_name, author, published_date) values (book_seq.NEXTVAL, 'KARMA2' , 'Sadhguru2' , TO_DATE('13.09.2007','DD.MM.YYYY'));
insert into book (book_id, book_name, author, published_date) values (book_seq.NEXTVAL, 'KARMA3' , 'Sadhguru3' , TO_DATE('13.09.2007','DD.MM.YYYY'));
insert into book (book_id, book_name, author, published_date) values (book_seq.NEXTVAL, 'The Monk Who sold his Ferrari' , 'Robin Sharma' , TO_DATE('17.10.2020','DD.MM.YYYY'));
insert into book (book_id, book_name, author, published_date) values (book_seq.NEXTVAL, 'ALL TIME BEST BOOK- YET TO COME ' , 'Purnachandra Gudipudi' , TO_DATE('13.09.2024','DD.MM.YYYY'));
insert into book (book_id, book_name, author, published_date) values (book_seq.NEXTVAL, 'Inner Engineering' , 'JAGGI' , TO_DATE('01.01.2015','DD.MM.YYYY'));
insert into book (book_id, book_name, author, published_date) values (book_seq.NEXTVAL, 'ONly love is real' , 'Unlce John' , TO_DATE('08.04.2004','DD.MM.YYYY'));
insert into book (book_id, book_name, author, published_date) values (book_seq.NEXTVAL, 'Pathanjali' , 'Pathanjali Maharshi' , TO_DATE('04.08.2006','DD.MM.YYYY'));
insert into book (book_id, book_name, author, published_date) values (book_seq.NEXTVAL, 'Ayurveda' , 'Nature' , TO_DATE('11.12.2002','DD.MM.YYYY'));
insert into book (book_id, book_name, author, published_date) values (book_seq.NEXTVAL, 'AKARMA' , 'Jaggi' , TO_DATE('13.09.2007','DD.MM.YYYY'));
insert into book (book_id, book_name, author, published_date) values (book_seq.NEXTVAL, 'AKARMA1' , 'Jaggi' , TO_DATE('13.09.2007','DD.MM.YYYY'));
insert into book (book_id, book_name, author, published_date) values (book_seq.NEXTVAL, 'ZKARMA2' , 'Vasudev' , TO_DATE('13.09.2007','DD.MM.YYYY'));
insert into book (book_id, book_name, author, published_date) values (book_seq.NEXTVAL, 'ZKARMA3' , 'Vasudev' , TO_DATE('13.09.2007','DD.MM.YYYY'));


--delete from book;
--select * from book;

