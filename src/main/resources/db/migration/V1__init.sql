CREATE TABLE Accounts(
    username varchar(30) PRIMARY KEY NOT NULL,
    password varchar(30) NOT NULL
)
CREATE TABLE Students(
    id int AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name varchar(30) NOT NULL,
    surname varchar (30),
    language_level varchar (30),
    weeks int,
    nationality varchar (40),
    date_of_birth DATE
)
CREATE TABLE Teachers(
    id int AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name varchar(30),
    surname varchar (30),
    account varchar (30) REFERENCES Accounts(username)
)
CREATE TABLE GrandMasters(
    id int AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name varchar(30),
    surname varchar (30),
    account varchar (30) REFERENCES Accounts(username)
)
CREATE TABLE Courses(
    id int AUTO_INCREMENT PRIMARY KEY NOT NULL,
    level varchar(30),
    begin_date DATE,
    end_date DATE
)
