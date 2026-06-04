# Write your MySQL query statement below
select students.student_id , students.student_name,subjects.subject_name,
count(examinations.subject_name) as attended_exams 
from students cross join subjects 
left join examinations on examinations.student_id = students.student_id and examinations.subject_name = subjects.subject_name
group by examinations.subject_name,students.student_id,subjects.subject_name
order by students.student_id , subjects.subject_name
