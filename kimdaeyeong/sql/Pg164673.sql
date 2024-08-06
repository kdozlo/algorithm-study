-- PG 164673: 조건에 부합하는 중고거래 댓글 조회하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/164673

select
    b.title, b.board_id, r.reply_id, r.writer_id, r.contents, DATE_FORMAT(r.created_date, '%Y-%m-%d') as 'CREATED_DATE'
from
    USED_GOODS_BOARD b
        join
    USED_GOODS_REPLY r
    on
            b.board_id = r.board_id
where
    month(b.created_date) = 10
order by r.created_date, b.title
;