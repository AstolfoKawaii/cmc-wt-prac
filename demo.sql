begin;

insert into users (full_name, email, phone, mailing_address, passwd_hash) values
    ('Anna Abramova', 'anna@abramova.dev', '+11234567890', '9 Collage Ter San Francisco CA 94112', 'e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855'),
    ('Dmitry Fomin', 'fo@m.in', '+7102938192', '5415 Almeda Ave Arverne NY 11692', 'cfba1181945d042e7317d0e4bacea5ec9994e571a2372f3e9a2be0dc526b97f8'),
    ('Andrey Karpov', 'al@ca.sh', '+79858765005', 'Krasnodar, Dzerzhinsky Street, 8', 'f51af67e2a2fcfdb209e706d044f2442b363196860f4e7b7ede1d2914d0547ef');

insert into books (title, description, price, quantity, seller_id, additional_info) values
    ('Breath, Eyes, Memory', 'A book about Breath, Eyes, and Memory', 1700, 0, 1, '{}'::jsonb),
    ('House of Flame and Shadow', 'A book about a house with some flames and shadows', 1100, 10, 1, '{}'::jsonb),
    ('The Heaven & Earth Grocery Store', 'Something about carrots', 2000, 12, 1, '{}'::jsonb);

insert into genres (genre) values
    ('Fiction'),
    ('Peak fiction'),
    ('Documentary');

insert into genre_book (genre_id, book_id) values
    (1, 1),
    (2, 1),
    (3, 1);

insert into authors (full_name) values
    ('Eniola Lindiwe'),
    ('Wangui Kgosi'),
    ('Naa Abeni');

insert into author_book (author_id, book_id) values
    (1, 1),
    (2, 1),
    (3, 1);

insert into orders (book_id, buyer_id, mailing_address, total_actual_price, quantity, placed_at, status, updated_at) values
    (1, 2, '5415 Almeda Ave Arverne NY 11692', 2000, 2, '2024-01-08 04:05:06', 'NEW', '2024-01-08 04:05:06'),
    (1, 3, 'Krasnodar, Dzerzhinsky Street, 8', 20000, 25, '2024-01-26 05:32:12', 'APPROVED', '2024-01-26 05:32:12'),
    (3, 3, 'Krasnodar, Dzerzhinsky Street, 8', 300, 1, '2024-02-01 05:15:29', 'DELIVERED', '2024-02-01 05:15:29');

commit;
