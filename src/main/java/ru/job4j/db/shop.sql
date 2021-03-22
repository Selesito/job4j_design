create table shop(
     id serial primary key,
     name varchar(255),
	 weight int,
     number int
 );

create table sellers(
     id serial primary key,
     name varchar(255),	 
     shop_id int references shop(id)
 );
 
insert into shop(name, weight, number) values ('vegetables', 1250, 4);
insert into shop(name, weight, number) values ('grains', 800, 1);
insert into shop(name, weight, number) values ('bread', 100, 3);
insert into shop(name, weight, number) values ('water', 500, 2);

insert into sellers(name, shop_id) values('Boris', 1);
insert into sellers(name, shop_id) values('Ivan', 2);
insert into sellers(name, shop_id) values('Kiril', 3);
insert into sellers(name, shop_id) values ('Marina', 2);
insert into sellers(name, shop_id) values ('Pers', 4);

insert into sellers(name) values ('Viktor');
insert into sellers(name) values ('Alex');

select * from sellers join shop p on sellers.shop_id = p.id;
select pp.name, p.name, p.weight, p.number from sellers as pp join shop as p on pp.shop_id = p.id; 
select pp.name as Имя, p.name as Прилавок, p.weight as Вес, p.number as Номер from sellers as pp join shop as p on pp.shop_id = p.id; 
