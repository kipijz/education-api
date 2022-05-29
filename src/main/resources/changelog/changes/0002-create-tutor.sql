-- liquibase formatted sql

-- changeset kristaps:1

CREATE TABLE tutor
(
    id      serial primary key,
    name    varchar(255) not null,
    surname varchar(255) not null
)