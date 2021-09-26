


--#176. 第二高的薪水
--#很值得做的一道，distinct isNull
--# Write your MySQL query statement below

select ifNull(
    (Select Salary as SecondHighestSalary from (
    select distinct Salary from Employee  order by Salary  DESC
    ) as a limit 1,1)
    ,null
) as SecondHighestSalary