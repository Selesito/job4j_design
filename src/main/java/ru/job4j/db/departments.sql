create table departments(
    id serial primary key,
    name varchar(255)
);

create table emploees(
    id serial primary key,
    name varchar(255),
    department_id int references departments(id)
);

insert into departments(name) values ('Медицины');
insert into departments(name) values ('Образования');
insert into departments(name) values ('Безопасности');
insert into departments(name) values ('Недвижимости');

insert into emploees(name, department_id) values ('Ваня', 1);
insert into emploees(name, department_id) values ('Никита', 2);
insert into emploees(name, department_id) values ('Петр', 3);
insert into emploees(name, department_id) values ('Стас', null);
insert into emploees(name, department_id) values ('Сергей', null);
insert into emploees(name, department_id) values ('Юрий', 1);

select * from departments d left join emploees o on o.department_id = d.id where o.id is null;

select * from departments d left join emploees o on o.department_id = d.id;
select * from emploees d right join departments o on d.department_id = o.id;


create table teens(
    id serial primary key,
    name varchar(255),
    gender varchar(255)
);

insert into teens(name, gender) values ('Ваня', 'man');
insert into teens(name, gender) values ('Виктор', 'man');
insert into teens(name, gender) values ('Стас', 'man');
insert into teens(name, gender) values ('Эдик', 'man');

insert into teens(name, gender) values ('Лида', 'woman');
insert into teens(name, gender) values ('Зоя', 'woman');
insert into teens(name, gender) values ('Индира', 'woman');
insert into teens(name, gender) values ('Настюха', 'woman');

select t1.name as a, t2.name as b from teens t1 cross join teens t2
where t1.gender = 'man' and t2.gender = 'woman';