-- liquibase formatted sql

-- changeset kristaps:1

CREATE TABLE student_course
(
    student_id int,
    course_id  int,
    constraint student_id_fkey foreign key (student_id) references student (id),
    constraint course_id_fkey foreign key (course_id) references course (id)
)