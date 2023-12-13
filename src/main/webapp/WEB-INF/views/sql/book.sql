show tables;

/* 도서 주문관리 프로젝트에 필요한 테이블 설계 */
/* 고객테이블 */
create table customers (
  custid  int not null AUTO_INCREMENT PRIMARY KEY,	/* 고객 고유번호 */
  name    varchar(20)  not null,		/* 고객명 */
  address varchar(30)  not null,		/* 고객주소 */
  phone   varchar(15)  not null			/* 고객 연락처 */
);

/* 책정보 테이블 */
create table books (
  bookid    int not null AUTO_INCREMENT  PRIMARY KEY,	/* 책 고유번호 */
  bookname  varchar(30) not null,	/* 책이름 */
  publisher varchar(20) not null,	/* 출판사명 */
  price     int not null			/* 책가격(정가) */
);

/* 주문 테이블 */
create table orders (
  orderid  int not null AUTO_INCREMENT PRIMARY KEY,	/* 주문 고유번호 */
  custid   int not null,		/* 고객 고유번호(고객테이블의 고유번호이다.) */
  bookid   int not null,		/* 책 고유번호(책테이블의 고유번호이다.) */
  saleprice int not null,		/* 실제 책 구입가격 */
  orderdate TIMESTAMP,			/* 책 주문 날짜 */
  FOREIGN KEY(custid) REFERENCES customers(custid) on update RESTRICT,
  FOREIGN KEY(bookid) REFERENCES books(bookid) on update RESTRICT
);

/* 각각의 테이블 구조 확인 */
desc customers;
desc books;
desc orders;

/* 자료파일 */
-- books(책정보)
INSERT INTO books VALUES(1, '축구의 역사', '굿스포츠', 7000);
INSERT INTO books VALUES(2, '축구아는 여자', '나무수', 13000);
INSERT INTO books VALUES(3, '축구의 이해', '대한미디어', 22000);
INSERT INTO books VALUES(4, '골프 바이블', '대한미디어', 35000);
INSERT INTO books VALUES(5, '피겨 교본', '굿스포츠', 8000);
INSERT INTO books VALUES(6, '역도 단계별기술', '굿스포츠', 6000);
INSERT INTO books VALUES(7, '야구의 추억', '이상미디어', 20000);
INSERT INTO books VALUES(8, '야구를 부탁해', '이상미디어', 13000);
INSERT INTO books VALUES(9, '올림픽 이야기', '삼성당', 7500);
INSERT INTO books VALUES(10, 'Olympic Champions', 'Pearson', 13000);
INSERT INTO books VALUES(11, '가나다', '삼성당', 17500);
INSERT INTO books VALUES(12, '포토샵CS6', '제우미디어', 25000);
INSERT INTO books VALUES(13, '아시안게임 이야기', '스포츠북', 19500);
INSERT INTO books VALUES(14, '우리들 이야기', '우리출판사', 5000);
INSERT INTO books VALUES(15, '서로 사랑하자', '이상미디어', 18000);
INSERT INTO books VALUES(16, '하나된 마음으로', '대한미디어', 21000);
INSERT INTO books VALUES(17, '나눌수 있을때', '나무수', 9000);
INSERT INTO books VALUES(18, '함박눈 내리는날', '이상미디어', 15000);
INSERT INTO books VALUES(19, '나보다 축구를', '굿스포츠', 23000);
INSERT INTO books VALUES(20, '시작했을때 한번더', '삼성당', 19000);



-- customers(고객정보)
INSERT INTO customers VALUES (1, '박지성', '영국 맨체스타', '000-5000-0001');
INSERT INTO customers VALUES (2, '김연아', '대한민국 서울', '000-6000-0001');  
INSERT INTO customers VALUES (3, '김말숙', '대한민국 강원도', '000-7000-0001');
INSERT INTO customers VALUES (4, '손흥민', '영국 토트넘', '000-8000-0001');
INSERT INTO customers VALUES (5, '박세리', '대한민국 대전',  '001-0011-0012');
INSERT INTO customers VALUES (6, '이순신', '대한민국 아산',  '001-0009-0007');
INSERT INTO customers VALUES (7, '손흥민', '영국 토트넘',  '000-1100-005');

-- orders(주문정보) 데이터 생성
INSERT INTO orders VALUES (1, 1, 1, 6000, '2019-08-01'); 
INSERT INTO orders VALUES (2, 1, 3, 21000, '2018-09-03');
INSERT INTO orders VALUES (3, 2, 5, 8000, '2022-11-03'); 
INSERT INTO orders VALUES (4, 3, 6, 6000, '2020-06-04'); 
INSERT INTO orders VALUES (5, 4, 7, 19000, '2019-11-05');
INSERT INTO orders VALUES (6, 1, 2, 12000, '2021-09-07');
INSERT INTO orders VALUES (7, 4, 8, 11000, '2019-03-07');
INSERT INTO orders VALUES (8, 3, 10, 12000, '2021-07-08');
INSERT INTO orders VALUES (9, 2, 10, 9000, '2017-05-09');
INSERT INTO orders VALUES (10, 3, 18, 13000, '2022-10-11');
INSERT INTO orders VALUES (11, 7, 15, 15000, '2022-06-17');
INSERT INTO orders VALUES (12, 7, 20, 16000, '2022-12-19');
INSERT INTO orders VALUES (13, 3, 19, 23000, '2022-06-30');
INSERT INTO orders VALUES (14, 1, 16, 17000, '2022-11-21');
INSERT INTO orders VALUES (15, 4, 15, 13000, '2022-05-12');
INSERT INTO orders VALUES (16, 7, 10, 13000, '2022-09-24');
INSERT INTO orders VALUES (17, 1, 12, 23000, '2022-02-26');
INSERT INTO orders VALUES (18, 2, 11, 13000, '2022-09-16');
INSERT INTO orders VALUES (19, 4, 20, 13000, '2022-03-20');
INSERT INTO orders VALUES (20, 4, 15, 20000, '2023-04-26');
INSERT INTO orders VALUES (21, 1, 15, 13000, '2023-10-12');

/* 테이블의 자료 확인 */
select * from customers;
select * from books;
select * from orders;

/* ---------------------------------------------------------------- */

-- 출판사가 '굿스포츠' 또는 '대한미디어'인 도서를 검색하세요.
select * from books where publisher= '굿스포츠' or publisher='대한미디어';
select * from books where publisher in('굿스포츠' ,'대한미디어');
select * from books where publisher like '%굿스포츠%' or publisher like '%대한미디어%';

-- 각각의 테이블에 별명지정 검색
select * from books b; 
select * from orders o;

-- books 테이블과 orders 테이블의 정보를 모두 함께 출력하시오.
select * from books, orders;
select * from books b, orders o;

-- books테이블과 orders테이블의 정보들 중에서 서로간의 관계설정이 된 자료들만 출력하시오?
select * from books b, orders o where b.bookid = o.bookid;

-- books테이블과 orders테이블과 customers테이블의 정보들 중에서 서로간의 관계설정이 된 자료들만 출력하시오?
select * from books b, orders o,customers c where b.bookid = o.bookid and c.custid = o.custid;

-- 1번 이상 구매한 책들의 정보를 bookid로 오름차순 정렬해서 보여주시오.
select * from orders order by bookid;

-- 1번 이상 구매한 책들의 정보를 bookid로 오름차순 정렬해서 보여주시오(책이름을 보여주세요.).
select o.bookid as bid,b.bookname from orders o,books b where o.bookid= b.bookid order by o.bookid;

-- 1번 이상 구매한 책들의 정보를 bookid로 오름차순 정렬해서 보여주시오(책이름을 보여주세요. -같은 자료는 1회만 출력?).
select o.bookid as bid,b.bookname from orders o,books b where o.bookid= b.bookid group by o.bookid order by o.bookid;

-- 1번 이상 구매한 책들의 정보를 bookid로 오름차순 정렬해서 보여주시오(책이름을 보여주세요. -같은 자료는 1회만 출력?, 또 구매된 책의 수량도 함께 출력?).
select o.bookid as bid,b.bookname,count(o.bookid) as cnt from orders o,books b where o.bookid= b.bookid group by o.bookid order by o.bookid;

-- 출판사가 '굿스포츠' 또는 '대한미디어'인 도서를 검색하세요.
select * from books where publisher in('굿스포츠','대한미디어');

-- 출판사가 '굿스포츠' 또는 '대한미디어'가 아닌 도서를 검색하세요.
select * from books where publisher not in('굿스포츠','대한미디어');

-- 출판사가 '굿스포츠'인 책들중 판매된 책들의 리스트를 출력하시오?
select bookname from books b, orders o where b.publisher = '굿스포츠' and o.bookid = b.bookid;

-- 고객이 주문한 주문테이블의 목록을 보여주되, 주문한 책의 책이름과 그 책을 주문한 고객의 이름까지 함께 출력하시오. 
SELECT c.name,b.bookname,o.* FROM orders o, books b, customers c WHERE o.bookid=b.bookid AND o.custid= c.custid;

-- 고객이 주문한 주문한 책의 책이름과 그 책을 주문한 고객의 이름, 주문날짜를 보여주되 최신주문날짜순으로 출력하시오.
SELECT c.name,b.bookname,o.orderdate FROM orders o, books b, customers c WHERE o.bookid=b.bookid AND o.custid= c.custid order by orderdate desc;

-- 책주문이 4번이상 주문한 고객에 해당하는 '고객아이디'를 출력하시오.
select custid,count(custid) from orders group by custid; 
select custid,count(custid) from orders group by custid having count(*) >=4; 
select custid,count(custid) as cnt from orders group by custid having cnt >=4; 

-- 책주문이 4번이상 주문한 고객에 해당하는 '고객아이디'를 출력하시오. 적게 구매한 순으로 출력?
select custid,count(custid) as cnt from orders group by custid having cnt >=4 order by cnt;
select custid,count(custid) from orders group by custid having count(*) >=4 order by count(*);

-- 책주문이 4번이상 주문한 고객에 해당하는 '고객아이디'와 고객명을 출력하시오. 적은 구매한 순으로 출력?
select c.name,o.custid,count(o.custid) as cnt from orders o, customers c where o.custid=c.custid group by o.custid having cnt >=4 order by cnt;

-- 서브쿼리 : 조건안에서의 조건 검색? 서브쿼리는 괄호()로 묶어준다.

-- 주문한 책가격이 10000원~15000원인 책들을 내림차순으로 출력?
select * from orders where saleprice >=10000 and saleprice <=15000 order by saleprice desc;

-- 주문한 책을 내림차순으로 출력하되, 책가격이 10000원~15000원인 책들만 출력하시오?
select * from orders order by saleprice desc;

-- 서브쿼리로 임시로 만들어진 테이블 ((select * from orders order by saleprice desc))
select * from (select * from orders order by saleprice desc) as temp where saleprice >=10000 and saleprice <=15000;

-- 도서를 한번이라도 구매한적이 있는 '고객명'을 출력하시오.
select * from customers where custid in(select custid from orders); 

-- 도서를 한번이라도 구매한적이 없는 '고객명'을 출력하시오.
select * from customers where custid not in(select custid from orders);

-- 평균판매가격 이상으로 판매된 책코드와 책명, 정가와 판매가격을 출력하시오.
select b.bookid,b.bookname,b.price,o.saleprice from books b, orders o where o.saleprice >= (select avg(saleprice) from orders) and o.bookid = b.bookid;

-- 출판사가 '대한미디어'나 '삼성당'에서 출판한 도서를 구매한 고객의 이름을 출력하시오.
select c.custid,c.name,o.bookid from orders o, customers c 
	where o.bookid in(select bookid from books where publisher= '대한미디어' or publisher='삼성당') 
	and o.custid = c.custid;