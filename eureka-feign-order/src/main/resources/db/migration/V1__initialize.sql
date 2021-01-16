create table orders (
    id                      bigserial primary key,
    price                   int,
    quantity                int
);



insert into orders (price, quantity)
values
(100, 2),
(200, 1),
(10, 5);
