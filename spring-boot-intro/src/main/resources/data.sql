DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS customer_orders;

CREATE TABLE customers(
    customer_id INT NOT NULL,
    first_name VARCHAR(32),
    second_name VARCHAR(64),
    PRIMARY KEY (customer_id)
);

CREATE TABLE customer_orders(
    order_id INT NOT NULL,
    price DOUBLE,
    customer_id INT,
    PRIMARY KEY (order_id),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);