/* Create a function to calculate number of orders in a month. Month and year will be input parameter to function.*/
delimiter $$
create function orders_count(month int,year int)
returns int
begin
    declare numberOfOrder int;
    
    select count(*) into numberOfOrder from customer_order
        where month(order_date)= month and year(order_date)=year;
        return (numberOfOrder);
        
end$$

delimiter ;
        
select orders_count(3, 2021) as total_orders;
        
        
 /*Create a function to return month in a year having maximum orders. Year will be input parameter.*/       
 delimiter $$
create function maximumMonthOrder(year int)
 returns int
 begin
    declare output int;
    
    select month into output from (
    
    select count(*) as orders_count,month(order_date) as month
        from customer_order where year(order_date) =year group by month order by orders_count desc
        ) as table1 limit 1;
        return (output);
            
end$$

delimiter ;
            
select maximumMonthOrder(2021) as Month;
                
 
drop function maximumMonthOrder;
 
 