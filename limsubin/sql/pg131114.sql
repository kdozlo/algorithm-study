# PG 131114: 경기도에 위치한 식품창고 목록 출력하기
# https://school.programmers.co.kr/learn/courses/30/lessons/131114

select warehouse_id, warehouse_name, address,
        case when freezer_yn is null then 'N'
                else freezer_yn
                end as freezer_yn
from food_warehouse
where address like "경기도%"
order by warehouse_id;