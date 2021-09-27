--# Write your MySQL query statement below
--
--
--181. 超过经理收入的员工
--Employee 表包含所有员工，他们的经理也属于员工。每个员工都有一个 Id，此外还有一列对应员工的经理的 Id。
--
--思路：先把老板的信息合并到一个表里来，再查询一次比较薪资就饿可以了。

SELECT Name as Employee from
(SELECT e1.Name, e1.Salary as Salary,e2.Salary as mSalary
from Employee as e1, Employee as e2
where e1.ManagerId = e2.Id) as a
where Salary>mSalary