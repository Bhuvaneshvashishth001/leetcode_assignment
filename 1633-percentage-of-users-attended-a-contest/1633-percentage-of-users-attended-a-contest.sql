# Write your MySQL query statement below
select register.contest_id , 
round(count(register.user_id)/(select count(*) from users) * 100,2)  
as percentage
from register inner join users 
on register.user_id = users.user_id 
group by register.contest_id
order by percentage desc , contest_id asc