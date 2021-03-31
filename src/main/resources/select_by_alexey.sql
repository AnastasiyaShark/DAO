select product_name
from ORDERS
         RIGHT JOIN  customers on ORDERS.customer_id = customers.id
WHERE customers.id in (select id from customers where lower(name) = lower(:name));