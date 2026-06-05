# Write your MySQL query statement below
select prices.product_id ,ROUND(
        IFNULL(SUM(prices.price * unitsSold.units) / SUM(unitsSold.units), 0),
        2
    ) AS average_price
from prices
left join unitssold 
on prices.product_id = unitsSold.product_id 
and unitsSold.purchase_date between prices.start_date 
and prices.end_date 
group by prices.product_id