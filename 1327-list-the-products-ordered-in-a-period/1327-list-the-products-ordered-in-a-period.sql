# Write your MySQL query statement below
select products.product_name,sum(unit) as unit from
products inner join orders
on products.product_id = orders.product_id
where orders.order_date between '2020-02-01' and '2020-02-29'
group by orders.product_id
having sum(unit)>=100