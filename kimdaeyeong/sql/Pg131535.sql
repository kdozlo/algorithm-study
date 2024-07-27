-- PG 131535: 조건에 맞는 회원수 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131535

select count(user_id) as 'USERS'
from user_info
where year(joined) = 2021 and
    age > 19 and age < 30
;