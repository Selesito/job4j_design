vcreate table type(
    id serial primary key,
    name varchar(255)
);

create table product(
    id serial primary key,
    name varchar(255),
	type_id int references type(id),
	expired_date timestamp,
	price float
);

insert into type(name) values ('СЫР');
insert into type(name) values ('МОЛОКО');
insert into type(name) values ('ХЛЕБ');
insert into type(name) values ('Заморозка');
insert into type(name) values ('Охлажденое');
insert into type(name) values ('Фрукты');



insert into product(name, type_id, expired_date, price) values ('РОССИЙСКИЙ', 1, date '2021-04-15', 450);
insert into product(name, type_id, expired_date, price) values ('ГАУДА', 1, date '2021-03-28', 760);
insert into product(name, type_id, expired_date, price) values ('НАШ', 1, date '2021-05-03', 120);
insert into product(name, type_id, expired_date, price) values ('ВАШ', 1,  date '2021-04-04', 380);

insert into product(name, type_id, expired_date, price) values ('БУРЁНКА', 2, date '2021-04-10', 120);
insert into product(name, type_id, expired_date, price) values ('ЧАБАН', 2, date '2021-03-28', 100);
insert into product(name, type_id, expired_date, price) values ('ДЕРЕВНЯ', 2, date '2021-06-03', 70);
insert into product(name, type_id, expired_date, price) values ('КОЛХОЗ', 2,  date '2021-04-01', 80);

insert into product(name, type_id, expired_date, price) values ('ТРУСОВСКИЙ', 3, date '2021-04-02', 35);
insert into product(name, type_id, expired_date, price) values ('КИРОВСКИЙ', 3, date '2021-03-28', 40);
insert into product(name, type_id, expired_date, price) values ('ЛЕНИНСКИЙ', 3, date '2021-03-25', 25);
insert into product(name, type_id, expired_date, price) values ('РЕДУКТОРНЫЙ', 3,  date '2021-04-01', 36);

insert into product(name, type_id, expired_date, price) values ('МЯСО МОРОЖЕННОЕ', 4, date '2021-06-02', 250);
insert into product(name, type_id, expired_date, price) values ('ГРУДКА МОРОЖЕННАЯ', 4, date '2021-07-28', 200);
insert into product(name, type_id, expired_date, price) values ('МАСЛО МОРОЖЕННОЕ', 4, date '2021-03-24', 90);
insert into product(name, type_id, expired_date, price) values ('КЕФИР ЗАМОРОЖЕННЫЙ', 4,  date '2021-05-01', 480);

insert into product(name, type_id, expired_date, price) values ('МЯСО', 5, date '2021-04-02', 340);
insert into product(name, type_id, expired_date, price) values ('КУРИЦА', 5, date '2021-03-28', 230);
insert into product(name, type_id, expired_date, price) values ('СТЕЙК', 5, date '2021-03-25', 700);
insert into product(name, type_id, expired_date, price) values ('ГОЛЕНИ', 5,  date '2021-04-01', 280);

insert into product(name, type_id, expired_date, price) values ('ЯБЛОКИ', 6, date '2021-04-02', 70);
insert into product(name, type_id, expired_date, price) values ('БАНАНЫ', 6, date '2021-04-28', 55);
insert into product(name, type_id, expired_date, price) values ('АПЕЛЬСИНЫ', 6, date '2021-03-25', 45);
insert into product(name, type_id, expired_date, price) values ('МАНДАРИНЫ', 6,  date '2021-04-01', 80);

select s.name, ss.name from product as ss join type s on ss.type_id = s.id
group by s.name, ss.name
having s.name like '%СЫР%';

select s.name, ss.name from product as ss join type s on ss.type_id = s.id
group by s.name, ss.name
having ss.name like '%МОРОЖЕННОЕ%';

select name, expired_date from product
group by name, expired_date
having expired_date < '01.05.2021';

select  max(price) from product

select s.name, count(*) from product as ss join type s on ss.type_id = s.id
group by s.name;

select s.name, ss.name from product as ss join type s on ss.type_id = s.id
group by s.name, ss.name
having s.name like '%СЫР%' or s.name like '%МОЛОКО%';

select s.name, count(*) from product as ss join type s on ss.type_id = s.id
group by s.name
having count(*) < 10;

select s.name, ss.name from product as ss join type s on ss.type_id = s.id
group by s.name, ss.name;
