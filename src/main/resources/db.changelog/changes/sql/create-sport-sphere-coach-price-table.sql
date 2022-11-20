create table if not exists sport_sphere_coach_price
(
    coach_id bigserial not null
        references coach(person_id),
    sport_sphere_id bigserial not null
        references sport_sphere(id),
    price int not null
        check (price > 0),
    primary key (coach_id, sport_sphere_id)
);