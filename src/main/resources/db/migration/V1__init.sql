CREATE TABLE students (
    id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name varchar(30) NOT NULL,
    surname varchar (30),
    language_level varchar (30),
    weeks int,
    nationality varchar (40),
    date_of_birth DATE
);

CREATE TABLE users (
    username varchar(30) PRIMARY KEY NOT NULL,
    name varchar(30),
    surname varchar (30),
    password varchar(30) NOT NULL,
    user_type varchar(30) NOT NULL
);

CREATE TABLE courses (
    id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    level varchar(30),
    begin_date DATE,
    end_date DATE,
    teacher varchar(30) REFERENCES users(username)
);

CREATE TABLE courses_students (
    course int REFERENCES courses(id) ON DELETE CASCADE ON UPDATE CASCADE,
    student int REFERENCES students(id) ON DELETE CASCADE ON UPDATE CASCADE
)
