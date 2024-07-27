# PG 131535: 조건에 맞는 회원수 구하기
# https://school.programmers.co.kr/learn/courses/30/lessons/131535

select count(user_id) as users
from user_info
where left(joined, 4) = 2021 and age >= 20 and age <= 29;
