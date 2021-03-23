
/* QuestiON 1*/
SELECT 
    product.product_id,
    product.product_title,
    count(product_category.product_id) AS Count_of_category
FROM
    product
        JOIN
    product_category ON product.product_id = product_category.product_id
GROUP BY product_category.product_id;

/*QuestiON 2*/
SELECT 
    '0-100' AS 'Range_in_rs.', count(*) AS count
FROM
    product
WHERE
    product_price > 0 AND product_price <= 100
GROUP BY 'Range-in-rs.'UNION SELECT 
    '100-500' AS 'Range-in-rs', count(*) AS count
FROM
    product
where
    product_price > 100 AND product_price <= 500
GROUP BY 'Range-in-rs'UNION SELECT 
    'Above 500' AS 'Range-in-rs', count(*) AS count
FROM
    product
WHERE
    product_price > 500
GROUP BY 'Range-in-rs';


/* QuestiON 3*/
SELECT 
    category.category_id,
    category.category_name,
    count(product_category.category_id) AS Count
FROM
    category
        LEFT JOIN
    product_category ON category.category_id = product_category.category_id
GROUP BY category.category_id;





