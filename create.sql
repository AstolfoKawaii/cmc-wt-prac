begin;

create table users (
    id serial primary key,
    full_name varchar(64) not null,
    email varchar(64) not null,
    phone varchar(64) not null,
    mailing_address text not null,
    passwd_hash varchar(64) not null
);

create table books (
    id serial primary key,
    title varchar(64) not null,
    description text not null,
    price money not null,
    quantity int not null,
    seller_id int not null references users,
    additional_info jsonb not null
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

create table orders (
    id serial primary key,
    book_id int not null references books,
    buyer_id int not null references users,
    mailing_address text not null,
    total_actual_price money not null,
    quantity int not null,
    datetime timestamp not null
);

commit;
