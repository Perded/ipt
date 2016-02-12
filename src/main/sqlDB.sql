
CREATE TABLE users
(
    id MEDIUMINT(9) PRIMARY KEY NOT NULL,
    username VARCHAR(15) NOT NULL,
    password VARCHAR(15)
);
CREATE UNIQUE INDEX users_id_uindex ON users (id);
CREATE UNIQUE INDEX users_username_uindex ON users (username);
CREATE TABLE iptn001
(
    col01 VARCHAR(20)
);
CREATE TABLE tnames
(
    name CHAR(150) DEFAULT 'temp' NOT NULL,
    tablename CHAR(7) PRIMARY KEY NOT NULL
);
CREATE UNIQUE INDEX tnames_tablename_uindex ON tnames (tablename);
CREATE TABLE iptn002
(
    col01 VARCHAR(20)
);
CREATE TABLE iptn003
(
    col01 VARCHAR(20)
);