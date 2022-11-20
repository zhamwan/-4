create table if not exists role
(
    id bigserial primary key not null,
    name varchar(255) not null
);

insert into role (name) values ('CLIENT'), ('COACH');