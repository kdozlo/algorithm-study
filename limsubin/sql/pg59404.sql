# PG 59404: 여러 기준으로 정렬하기
# https://school.programmers.co.kr/learn/courses/30/lessons/59404

select animal_id, name, datetime
from animal_ins
order by name, datetime desc