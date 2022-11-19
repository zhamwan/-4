create table if not exists group_person
(
    group_id bigserial not null
        references groups(id),
    person_id bigserial not null
        references person(id),
    primary key (group_id, person_id)
);