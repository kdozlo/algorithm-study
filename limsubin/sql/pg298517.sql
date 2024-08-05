# PG 298517: 가장 큰 물고기 10마리 구하기
# https://school.programmers.co.kr/learn/courses/30/lessons/298517

select id, length
from fish_info
order by length desc, id asc
limit 10;
