insert into roles (id, name) values (1, 'USER');
insert into roles (id, name) values (2, 'ADMIN');

insert into user (user_id, reg_date, email, name, phone, passwd)
values('user1', now(), 'urstory@gmail.com', 'kim', '01013241234', '{bcrypt}$2a$10$A89aTfML/3nbczHXmVDKR.uZoLn.MEvhJdc.A5eytJq58tyQZ2b0e');

insert into user (user_id, reg_date, email, name, phone, passwd)
values('user2', now(), 'carami@gmail.com', 'kang', '01013244567', '{bcrypt}$2a$10$A89aTfML/3nbczHXmVDKR.uZoLn.MEvhJdc.A5eytJq58tyQZ2b0e');

insert into user_roles(user_id, role_id) values( 'user1', 1);
insert into user_roles(user_id, role_id) values( 'user2', 1);
insert into user_roles(user_id, role_id) values( 'user1', 2);

INSERT INTO category(id, name) VALUES(1,'운동화');
INSERT INTO category(id, name) VALUES(2,'구두');
INSERT INTO category(id, name) VALUES(3,'슬리퍼');

-- INSERT INTO product(product_id,product_name,product_price,category_id,reg_date) VALUE ('aaa','상품이름a',55000,1,now());
-- INSERT INTO product(product_id,product_name,product_price,category_id,reg_date) VALUE ('bbb','상품이름b',55000,2,now());
-- INSERT INTO product(product_id,product_name,product_price,category_id,reg_date) VALUE ('ccc','상품이름c',55000,2,now());
-- INSERT INTO product(product_id,product_name,product_price,category_id,reg_date) VALUE ('ddd','상품이름d',55000,3,now());
-- INSERT INTO product(product_id,product_name,product_price,category_id,reg_date) VALUE ('eee','상품이름e',55000,3,now());

-- insert into blog(id, title, url, account_id) values(1, 'HELLO JAVA', 'java', 1);
-- insert into blog(id, title, url, account_id) values(2, 'HELLO JPA', 'JPA', 2);
--
-- insert into category(id, name, ordering, blog_id) values(1, '기본문법', 1, 1);
-- insert into category(id, name, ordering, blog_id) values(2, '객체지향문', 2, 1);
--
-- insert into category(id, name, ordering, blog_id) values(3, 'JPA', 1, 2);
-- insert into category(id, name, ordering, blog_id) values(4, 'JPQL', 2, 2);
--
-- insert into post(id, title, content, create_date, category_id) values(1, 'title1', 'content1', now(), 1);
-- insert into post(id, title, content, create_date, category_id) values(2, 'title2', 'content2', now(), 1);
-- insert into post(id, title, content, create_date, category_id) values(3, 'title3', 'content3', now(), 1);
-- insert into post(id, title, content, create_date, category_id) values(4, 'title4', 'content4', now(), 1);
-- insert into post(id, title, content, create_date, category_id) values(5, 'title5', 'content5', now(), 1);
-- insert into post(id, title, content, create_date, category_id) values(6, 'title6', 'content6', now(), 2);