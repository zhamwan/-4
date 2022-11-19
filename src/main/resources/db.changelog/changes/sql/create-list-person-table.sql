create table if not exists list_person
(
    chat_id bigserial not null
        references group_chat(id),
    person_id bigserial not null
        references person(id),
    primary key (chat_id, person_id)
);