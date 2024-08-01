-- PG 151138: 자동차 대여 기록에서 장기/단기 대여 구분하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/151138
select
    HISTORY_ID,
    CAR_ID,
    DATE_FORMAT(START_DATE, '%Y-%m-%d') as 'START_DATE',
        DATE_FORMAT(END_DATE, '%Y-%m-%d') as 'END_DATE',
        case
            when datediff(END_DATE, START_DATE) < 29
                then '단기 대여'
            else '장기 대여'
            end as 'RENT_TYPE'
from
    CAR_RENTAL_COMPANY_RENTAL_HISTORY c
where
    START_DATE between '2022-09-01' and '2022-09-30'
order by history_id desc
;