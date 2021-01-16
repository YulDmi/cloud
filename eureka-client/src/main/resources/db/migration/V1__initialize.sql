create table products (
    id                      bigserial primary key,
    name                    varchar(250),
    price                   int

);



insert into products (name, price)
values
('milk', 56),
('vino', 850),
('bread', 40);
