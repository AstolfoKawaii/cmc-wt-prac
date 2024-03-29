begin;

create table users (
    id serial primary key,
    full_name varchar(64) not null,
    email varchar(64) unique not null,
    phone varchar(64) not null,
    mailing_address text not null,
    passwd_hash varchar(64) not null,
    deleted bool not null default false
);

create table books (
    id serial primary key,
    title varchar(64) not null,
    description text not null,
    price int not null, -- in cents
    quantity int not null,
    seller_id int not null references users,
    additional_info jsonb not null,
    deleted bool not null default false
);

create table genres (
    id serial primary key,
    genre varchar(64) not null
);

create table genre_book (
    genre_id int not null references genres,
    book_id int not null references books,

    primary key (genre_id, book_id)
);

create table authors (
    id serial primary key,
    full_name varchar(64) not null
);

create table author_book (
    author_id int not null references authors,
    book_id int not null references books,

    primary key (author_id, book_id)
);

create type order_status as enum ('NEW', 'APPROVED', 'DELIVERED');

create table orders (
    id serial primary key,
    book_id int not null references books,
    buyer_id int not null references users,
    mailing_address text not null,
    total_actual_price int not null, -- in cents
    quantity int not null,
    placed_at timestamp not null,
    status order_status not null,
    updated_at timestamp not null
);

commit;
