-- liquibase formatted sql

-- changeset kristaps:1

CREATE TABLE course
(
    id      serial primary key,
    name    varchar(255) not null,
    student_id int not null,
    tutor_id int not null,
    constraint student_id_fkey foreign key (student_id) references student (id),
    constraint tutor_id_fkey foreign key (tutor_id) references tutor (id)
)