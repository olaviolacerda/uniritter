create database auth;

use auth;

create table auth (
        name            varchar(10) not null,
        pass            varchar(30) not null,
        primary key     (name)
);

insert into auth values
  ('user', 'pass');

insert into auth values
  ( 'testuser', password('test123') );

grant select, insert, update, delete
on auth.*
to webauth@localhost
identified by 'webauth';