create table bodywork(
    id serial primary key,
    name varchar(255)
);

create table engine(
    id serial primary key,
    name varchar(255)
);

create table transmission(
    id serial primary key,
    name varchar(255)
);

create table car(
    id serial primary key,
    name varchar(255)
	bodywork_id int references bodywork(id),
	engine_id int references engine(id),
	transmission_id int references transmission(id)
);

insert into bodywork(name) values ('A');
insert into bodywork(name) values ('B');
insert into bodywork(name) values ('C');
insert into bodywork(name) values ('D');

insert into engine(name) values ('QQ25');
insert into engine(name) values ('QQ35');
insert into engine(name) values ('QQR1');
insert into engine(name) values ('QQR2');

insert into transmission(name) values ('МТ');
insert into transmission(name) values ('АТ');
insert into transmission(name) values ('DSG');
insert into transmission(name) values ('CVT');

insert into car(name, bodywork_id, engine_id, transmission_id) values ('Crown', 2, 2, 2);
insert into car(name, bodywork_id, engine_id, transmission_id) values ('SuperB', 3, 3, 3);
insert into car(name, bodywork_id, engine_id, transmission_id) values ('Passat', 4, 4, 4);

select d.name as Car, t1.name as Bodywork, t2.name as Engine, t3.name as Transmission from car d left
join bodywork t1 on d.bodywork_id = t1.id
join engine t2 on d.engine_id = t2.id
join transmission t3 on d.transmission_id = t3.id;

select t1.name as Bodywork from bodywork as t1 left
join car as d on d.bodywork_id = t1.id  where d.bodywork_id is null;

select t1.name as Engine from engine as t1 left
join car as d on d.engine_id = t1.id  where d.engine_id is null;

select t1.name as Transmission from transmission as t1 left
join car as d on d.transmission_id = t1.id  where d.transmission_id is null;