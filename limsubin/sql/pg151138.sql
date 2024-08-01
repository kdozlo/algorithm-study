# PG 151138: 자동차 대여 기록에서 장기/단기 대여 구분하기
# https://school.programmers.co.kr/learn/courses/30/lessons/151138

select history_id, car_id,
    date_format(start_date, '%Y-%m-%d') as start_date,
    date_format(end_date, '%Y-%m-%d') as end_date,
    case when datediff(end_date, start_date) + 1 >= 30 then '장기 대여'
    else '단기 대여'
    end as rent_type
from car_rental_company_rental_history
where year(start_date) = 2022 and month(start_date) = 9
order by history_id desc;
