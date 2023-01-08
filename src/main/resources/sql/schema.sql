SELECT 'CREATE DATABASE worker'
WHERE NOT EXISTS(SELECT FROM pg_database WHERE datname = 'worker');


drop table if exists biometries;
drop table if exists stores;
drop table if exists users;
drop table if exists static_employee;

create table static_employee
(
    id          bigserial not null,
    user_id     bigint not null,
    store_id    bigint not null,
    create_date date not null,
    id_interval varchar(255) not null,
    count_work  integer not null,
    primary key (id)
);

create table biometries
(
    id         bigserial    not null,
    store_id   bigint       not null,
    user_id    bigint       not null,
    time_stamp timestamp(6) not null,
    is_active  boolean      not null,
    primary key (id)
);

create table stores
(
    id                 bigserial    not null,
    name               varchar(255) not null,
    open_date          time         not null,
    close_date         time         not null,
    is_round_the_clock boolean      not null,
    primary key (id)
);

create table users
(
    id        bigserial    not null,
    user_name varchar(255) not null,
    primary key (id)
);