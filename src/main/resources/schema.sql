DROP TABLE IF EXISTS CUSTOMERS,ORDERS cascade;
CREATE TABLE  CUSTOMERS(
                           id SERIAL PRIMARY KEY,
                           name VARCHAR,
                           surname VARCHAR,
                           age INT,
                           phone_number VARCHAR
);
INSERT INTO CUSTOMERS(name, surname, age, phone_number) VALUES ('Anastasiya','Sharkouskaya',24,'0734718720');
INSERT INTO CUSTOMERS(name, surname, age, phone_number) VALUES ('Viacheslav','Popov',30,'0762348972');
INSERT INTO CUSTOMERS(name, surname, age, phone_number) VALUES ('alexey','Bob',47,'0774569823');
INSERT INTO CUSTOMERS(name, surname, age, phone_number) VALUES ('Karim','Karimov',18,'0734891235');



CREATE TABLE ORDERS
(
    id           SERIAL PRIMARY KEY,
    date         timestamp not null default now(),
    customer_id  INT,
    product_name VARCHAR,
    amount       INT,
    FOREIGN KEY (customer_id) REFERENCES CUSTOMERS (id)
);
INSERT INTO ORDERS (customer_id, product_name, amount)
VALUES (1, 'Предмет 1', 242351),
       (2, 'Предмет 2', 304534),
       (3, 'Предмет 3', 475242),
       (4, 'Предмет 4', 43536455);