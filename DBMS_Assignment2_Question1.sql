
CREATE TABLE Product(
    product_title varchar(10) not null,
    product_id varchar(6),
    product_stock int(4) not null,
    product_price int(4) not null,
    product_description varchar(20),
    date_added date,
    Primary key (product_id)
);
CREATE TABLE Customer(
    customer_name char(10) not null,
    customer_id varchar(6),
    customer_phone varchar(11),
    primary key (customer_id)
);
CREATE TABLE Customer_order(
    order_id varchar(6),
    customer_id varchar(6),
    order_total int(6),
    primary key (order_id)
);
CREATE TABLE category(
    category_id varchar(6) primary key,
    category_name varchar(10),
    parent_category varchar(6),
    foreign key (parent_category)
        references category (category_id)
);
CREATE TABLE product_category(
    product_id varchar(6),
    category_id varchar(6),
    foreign key (product_id)
        references product (product_id),
    foreign key (category_id)
        references category (category_id),
    primary key (product_id,category_id)
); 
CREATE TABLE address(
    address_id varchar(6),
    address_city varchar(10),
    address_state varchar(10),
    address_house varchar(10),
    customer_id varchar(6),
    foreign key (customer_id)
        references customer (customer_id)
);
CREATE TABLE items(
    order_id varchar(6),
    product_id varchar(6),
    product_quantity int(6),
    shipping_status tinyint,
    primary key (order_id,product_id),
    foreign key (order_id)
        references customer_order (order_id),
    foreign key (product_id)
        references product (product_id)
);
CREATE TABLE images(
    image_id varchar(6),
    product_id varchar(6),
    image_path varchar(30),
    primary key (image_id),
    foreign key (product_id)
        references product (product_id)
);

SHOW TABLEs;

DROP TABLE Product;

CREATE TABLE Product(
    product_title varchar(10) not null,
    product_id varchar(6),
    product_stock int(4) not null,
    product_price int(4) not null,
    product_description varchar(20),
    Primary key (product_id)
);
