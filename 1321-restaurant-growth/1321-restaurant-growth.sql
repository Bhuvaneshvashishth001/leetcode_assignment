# Write your MySQL query statement below
SELECT DISTINCT c1.visited_on,
(
    SELECT SUM(c3.amount)
    FROM customer c3
    WHERE DATEDIFF(c1.visited_on, c3.visited_on) BETWEEN 0 AND 6
) AS amount,

ROUND(
    (
        SELECT SUM(c3.amount)
        FROM customer c3
        WHERE DATEDIFF(c1.visited_on, c3.visited_on) BETWEEN 0 AND 6
    ) / 7,
    2
) AS average_amount

FROM customer c1
JOIN customer c2
ON DATEDIFF(c1.visited_on, c2.visited_on) = 6;