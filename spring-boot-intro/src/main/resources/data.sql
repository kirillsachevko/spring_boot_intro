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

CREATE TABLE IF NOT EXISTS users(
    id INT NOT NULL,
    user_name VARCHAR(64),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS authorities(
    user_id INT NOT NULL,
    authority VARCHAR(32),
    CONSTRAINT fk_authorities_users FOREIGN KEY(user_id) REFERENCES users(id)
);