-- https://school.programmers.co.kr/learn/courses/30/lessons/131114
-- 방법 1. like 사용
select WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS,
       case
           when FREEZER_YN is null
               then 'N'
           when FREEZER_YN = 'Y'
               then 'Y'
           when FREEZER_YN = 'N'
               then 'N'
           end as FREEZER_YN
from FOOD_WAREHOUSE
where ADDRESS like '경기도%'
order by WAREHOUSE_ID;

-- 방법 2. left 사용
select WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS,
       case
           when FREEZER_YN is null
               then 'N'
           when FREEZER_YN = 'Y'
               then 'Y'
           when FREEZER_YN = 'N'
               then 'N'
           end as FREEZER_YN
from FOOD_WAREHOUSE
where left(ADDRESS, 3) = '경기도'
order by WAREHOUSE_ID;

-- 방법 3. substring 사용
select WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS,
       case
           when FREEZER_YN is null
               then 'N'
           when FREEZER_YN = 'Y'
               then 'Y'
           when FREEZER_YN = 'N'
               then 'N'
           end as FREEZER_YN
from FOOD_WAREHOUSE
where substring(ADDRESS, 1, 3) = '경기도'
order by WAREHOUSE_ID;

-- 방법 3. substr 사용
select WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS,
       case
           when FREEZER_YN is null
               then 'N'
           when FREEZER_YN = 'Y'
               then 'Y'
           when FREEZER_YN = 'N'
               then 'N'
           end as FREEZER_YN
from FOOD_WAREHOUSE
where substr(ADDRESS, 1, 3) = '경기도'
order by WAREHOUSE_ID;