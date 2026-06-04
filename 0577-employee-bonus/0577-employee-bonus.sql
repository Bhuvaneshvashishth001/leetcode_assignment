# Write your MySQL query statement below
select employee.name ,Bonus.bonus from employee
left join bonus on employee.empId = Bonus.empId
where Bonus.bonus is null or Bonus.bonus < 1000