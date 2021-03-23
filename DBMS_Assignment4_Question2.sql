/*Create a Stored procedure to retrieve average sales of each product in a month. Month and year will be input parameter to function.*/
delimiter $$

create procedure average_sales(IN month int,IN year int)
begin
    select product_id,avg(t1.product_sale) as average_sale from(

    select product_id,count(*) as product_sale
    from items 
    where order_id in(
    select order_id
    from customer_order
    where month(order_date) = month and year(order_date)=year
    )
    group by product_id) as t1 group by product_id;

end$$

delimiter ;


call average_sales(3,2021);

drop procedure average_sales;

/*Create a stored procedure to retrieve table having order detail with status for a given period. Start date and end date will be input parameter. Put validation on input dates like start date is less than end date. If start date is greater than end date take first date of month as start date.*/
delimiter $$
create procedure order_details(starts date,ends date)
begin
    if datediff(starts,ends)>0 then
    SET start =date(concat(yead(starts),"-",month(start),"-01"));
    end if;
    
    select * 
    from items 
    where order_id in(
    
    select order_id from orders 
    where date(order_date) >= start and date(order_date)<= ends);
    
end$$
    
delimiter ;
    
    





