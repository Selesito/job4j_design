create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price) values ('Ноутбук', 7200);
insert into devices(name, price) values ('Утюг', 3200);
insert into devices(name, price) values ('Телевизор', 6800);
insert into devices(name, price) values ('PS', 9400);
insert into devices(name, price) values ('iPad', 4150);
insert into devices(name, price) values ('Телефон', 2500);

insert into people(name) values ('Аня');
insert into people(name) values ('Ваня');
insert into people(name) values ('Боря');


insert into devices_people(device_id, people_id) values (2, 1);
insert into devices_people(device_id, people_id) values (4, 1);
insert into devices_people(device_id, people_id) values (6, 1);

insert into devices_people(device_id, people_id) values (1, 2);
insert into devices_people(device_id, people_id) values (3, 2);
insert into devices_people(device_id, people_id) values (5, 2);

insert into devices_people(device_id, people_id) values (2, 3);
insert into devices_people(device_id, people_id) values (3, 3);
insert into devices_people(device_id, people_id) values (6, 3);

select avg(price) from devices;

select sss.name, avg(s.price) 
from devices_people as ss join devices as s on ss.device_id = s.id 
join people as sss on ss.people_id = sss.id 
group by sss.name
having avg(s.price) > 5000;
