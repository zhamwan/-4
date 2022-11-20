create table if not exists group_chat
(
    id bigserial primary key not null,
    person_id bigserial not null
        references person(id),
    name varchar(255) not null
);

create index on group_chat using hash (person_id);