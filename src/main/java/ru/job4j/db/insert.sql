insert into users(name, roles_id) VALUES ('Ivan', 1);
insert into stateItem(name) VALUES ('Close');
insert into rules(name, roles_id) VALUES ('Open', 1);
insert into roles(name) VALUES ('Wolf');
insert into roles_rules(roles_id, roles_id) VALUES (1, 1);
insert into item(name, users_id, category_id, stateItem_id) VALUES ('Огурец', 1, 1, 1);
insert into comments_file(name, item_id) VALUES ('XxX', 1);
insert into category(name) VALUES ('Овощи');
insert into attachs(name, item_id) VALUES ('XxX', 1);
