create table if not exists groups
(
    id bigserial primary key not null,
    name varchar(255) not null unique,
    coach_id bigserial not null
        references coach(person_id),
    sport_sphere_id bigserial not null
        references sport_sphere(id),
    max_count int not null
        check (max_count > 0),
    count int not null
        check (count >= 0 and count <= groups.max_count),
    trains_left int not null
        check (trains_left >= 0)
);

create index on groups using hash (coach_id);