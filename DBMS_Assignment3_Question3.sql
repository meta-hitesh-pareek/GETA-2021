
/* Question 1 */
SELECT 
    customer.customer_id,
    customer.customer_name,
    address.address_city,
    count(customer_order.customer_id) AS total_order
FROM
    customer
        JOIN
    customer_order ON customer.customer_id = customer_order.customer_id
        LEFT JOIN
    address ON address.customer_id = customer_order.customer_id
WHERE
    datediff(CURRENT_TIMESTAMP,
            customer_order.order_date) < 30
GROUP BY customer_order.customer_id;

/* Question 2 */
SELECT 
    customer.customer_id,
    customer.customer_name,
    address.address_city,
    sum(customer_order.order_total) AS total_order
FROM
    customer
        JOIN
    customer_order ON customer.customer_id = customer_order.customer_id
        LEFT JOIN
    address ON address.customer_id = customer_order.customer_id
WHERE
    datediff(CURRENT_TIMESTAMP,
            customer_order.order_date) < 30
GROUP BY customer_order.customer_id
ORDER BY customer_order.order_total DESC
LIMIT 10;

/* Question 3 */
SELECT 
    t3.product_id, t3.count
FROM
    customer_order AS t1
        JOIN
    (SELECT 
        t2.order_id, t2.product_id, count(*) AS count
    FROM
        items AS t2
    GROUP BY t2.product_id) AS t3 ON t1.order_id = t3.order_id
WHERE
    datediff(CURRENT_TIMESTAMP, t1.order_date) < 60
ORDER BY t3.count DESC
LIMIT 20;


/* Question 4 */
SELECT 
    order_date AS MONTH, sum(order_total)
FROM
    customer_order
WHERE
    order_date between CURRENT_TIMESTAMP- INTERVAL 6 MONTH and CURRENT_TIMESTAMP
GROUP BY month;


/* Question 5 */

UPDATE product set product.inactive=true WHERE product.product_id not in(SELECT t2.product_id FROM
(SELECT customer_order.order_id FROM customer_order WHERE datediff(CURRENT_TIMESTAMP,customer_order.order_date)<90
) AS t1 RIGHT JOIN (SELECT items.order_id,items.product_id FROM items)AS t2 on t1.order_id=t2.order_id);


/* Question 6 */

SELECT 
    *
FROM
    product
WHERE
    product_id in (SELECT 
        product_id
    FROM
        product_category
    WHERE
        category_id in (SELECT 
            category_id
        FROM
            category
        WHERE
            locate('eat', category_name)));
            
/* Question 7 */
SELECT product_id,count(*) AS cancelled_time FROM items WHERE cancelled GROUP BY product_id
ORDER BY cancelled_time DESC LIMIT 10;



