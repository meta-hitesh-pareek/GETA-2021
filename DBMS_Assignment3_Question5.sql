/*Question 1*/
create view Order_Information as
select product.product_id,product.product_title,product.product_price,customer.customer_name,
customer_order.order_date,items.shipping_status 
from 
customer 
join
customer_order on customer.customer_id= customer_order.order_id
join
items
on 
customer_order.order_id=items.order_id 
join
product 
on 
items.product_id=
product.product_id;

    
/*Question 2 */
Select 
    product_id, product_title, customer_name
from
    order_information
where
    shipping_status = 1 ;


/* Question3*/
Select 
    product_id,
    product_title,
    count(product_id) as product_selled
from
    order_information
group by product_id
order by product_selled desc
limit 5;

