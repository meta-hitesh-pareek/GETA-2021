INSERT INTO product VALUES("Oil",101,40,100,"Oil for vegetables","2021-02-15");
INSERT INTO product VALUES("Soap",102,50,40,"Bathing soap","2021-02-15");
INSERT INTO product VALUES("Butter",103,30,20,"Butter slices","2021-02-10");
INSERT INTO product VALUES("comb",104,60,10,"Hair comb","2021-01-10");
INSERT INTO customer VALUES("Hitesh",1,7014087664);
INSERT INTO customer VALUES("Naman",2,7014343664);
INSERT INTO customer VALUES("Sachin",3,7354087664);
INSERT INTO customer VALUES("Naman",4,9844343664);
INSERT INTO customer_order value(1,1,200,"2021-02-10");
INSERT INTO customer_order value(2,3,100,"2021-01-14");
INSERT INTO customer_order value(3,2,100,"2021-03-16");
INSERT INTO category VALUES(1,"eatables",null);
INSERT INTO category VALUES(2,"cosmetics",null);
INSERT INTO category VALUES(3,"organic",1);
INSERT INTO category VALUES(4,"dailyUse",2);
INSERT INTO images VALUES("1","101","oil.jpg");
INSERT INTO images VALUES("2","102","soap.jpg");
INSERT INTO items VALUES(1,101,1,0);
INSERT INTO items VALUES(1,102,1,1);
SELECT 
    *
from
    customer_order;
SELECT 
    *
from
    product;

SELECT 
    product_title, product_id, product_price, date_added
FROM
    product
ORDER BY date_added desc;

SELECT 
    e.category_id,
    e.category_name,
    IFNULL(m.parent_category, 'Top Category') as Parent_Category
FROM
    category e
        LEFT JOIN
    category m ON e.category_id = m.category_id;

select 
    t1.category_id,
    t1.category_name,
    (select 
        t2.category_name
    from
        category as t2
    where
        t2.category_id = t1.parent_category) as parent_category
from
    category as t1
where
    t1.category_id not in (select distinct
        t3.parent_category
    from
        category t3
    WHERE
        t3.parent_category);


SELECT 
    *
from
    Product
WHERE
    product_stock < 50;

SELECT 
    product.product_id,
    product.product_price,
    product.product_description
FROM
    product
        JOIN
    product_category ON product.product_id = product_category.product_id
        JOIN
    category ON product_category.category_id = category.category_id
WHERE
    category_name = 'eatables';

SELECT 
    *
FROM
    product
WHERE
    product_id NOT IN (SELECT 
        product.product_id
    from
        product
            INNER JOIN
        images ON product.product_id = images.product_id);


