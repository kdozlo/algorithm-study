# PG 301646: 특정 형질을 가지는 대장균 찾기
# https://school.programmers.co.kr/learn/courses/30/lessons/301646

select count(*) as count
from ecoli_data
where conv(0010, 2, 10) & genotype = 0
        and (conv(0001, 2, 10) & genotype > 0 or conv(0100, 2, 10) & genotype > 0)