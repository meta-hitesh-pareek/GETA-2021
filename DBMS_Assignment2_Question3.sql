SELECT 
    order_id, order_date, order_total
FROM
    customer_order
ORDER BY order_date DESC
LIMIT 50;


SELECT 
    *
FROM
    customer_order
ORDER BY order_total DESC
LIMIT 10;

SELECT 
    *
FROM
    customer_order
        JOIN
    items ON customer_order.order_id = items.order_id
WHERE
    datediff(CURRENT_TIMESTAMP,
            customer_order.order_date) > 10 AND items.shipping_status = 0;

SELECT 
    customer.customer_id, customer.customer_name
FROM
    customer
        JOIN
    customer_order ON customer.customer_id = customer_order.customer_id
WHERE
    datediff(CURRENT_TIMESTAMP,
            customer_order.order_date) > 30;

SELECT 
    customer.customer_id,
    customer.customer_name,
    customer_order.order_id,
    customer_order.order_date
FROM
    customer
        JOIN
    customer_order ON customer.customer_id = customer_order.customer_id
WHERE
    datediff(CURRENT_TIMESTAMP,
            customer_order.order_date) < 15;


SELECT 
    *
FROM
    items
WHERE
    items.shipping_status = 1 AND items.order_id = 1;

SELECT 
    items.order_id,
    items.product_id,
    items.product_quantity,
    items.shipping_status
FROM
    items
        JOIN
    product ON product.product_id = items.product_id
WHERE
    product.product_price >= 20 AND product.product_price <= 50;
