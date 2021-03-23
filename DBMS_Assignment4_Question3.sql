/* Identify the columns require indexing in order, product, category tables and create indexes.*/

alter table category add index parent_index(parent_category);

alter table customer_order add index price_index(order_total);

alter table product add index stock_index(product_stock);