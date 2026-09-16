# Write your MySQL query statement below
select distinct(p.project_id) , round(avg(experience_years) over(partition by p.project_id),2) as average_years 
from project p inner join employee e
on p.employee_id = e.employee_id

