-- 코드를 작성해주세요
select D.dept_id, dept_name_en, round(AVG(SAL), 0) as avg_sal
from hr_department D join hr_employees E on D.dept_id = E.dept_id
group by dept_id
order by avg_sal desc