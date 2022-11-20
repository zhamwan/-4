create table if not exists list_message
(
    id bigserial primary key not null,
    chat_id bigserial not null
        references group_chat(id),
    person_id bigserial not null
        references person(id),
    content varchar(255) not null,
    date_create timestamp not null,
    unique (date_create, person_id)
);

create index on list_message using hash (chat_id);