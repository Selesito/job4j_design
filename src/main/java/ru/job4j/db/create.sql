create table users (
    id serial primary key,
    name varchar(2000),
	roles_id int references roles(id)
);

create table stateItem (
    id serial primary key,
    name varchar(2000)
);

create table rules (
    id serial primary key,
    name varchar(2000),
	roles_id int references roles(id)
);

create table roles (
    id serial primary key,
    name varchar(2000)
);

create table roles_rules (
    id serial primary key,
    roles_id int references roles(id),
    rules_id int references rules(id)
);

create table item (
    id serial primary key,
    name varchar(2000),
	users_id int references users(id),
	category_id int references category(id),
	stateItem_id int references stateItem(id)
);

create table comments_file (
    id serial primary key,
    name varchar(2000),
	item_id int references item(id)
);

create table category (
    id serial primary key,
    name varchar(2000)
);

create table attachs (
    id serial primary key,
    name varchar(2000),
	item_id int references item(id)
);
