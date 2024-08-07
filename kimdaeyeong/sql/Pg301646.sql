-- PG 301646: 특정 형질을 가지는 대장균 찾기
-- https://school.programmers.co.kr/learn/courses/30/lessons/301646

-- 나누기, 나머지 연산
select
    count(id) as 'count'
from
    ECOLI_DATA
where
    truncate((GENOTYPE / 2), 0) % 2 = 0
    and (GENOTYPE % 2 = 1 or truncate(truncate(GENOTYPE / 2, 0) / 2, 0) % 2 = 1)
;

-- 비트 연산
select
    count(id) as 'count'
from
    ECOLI_DATA
where
    GENOTYPE & 2 = 0 and (GENOTYPE & 1 = 1 or GENOTYPE & 4 = 4)
;