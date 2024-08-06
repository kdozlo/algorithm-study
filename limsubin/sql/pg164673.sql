# PG 164673: 조건에 부합하는 중고거래 댓글 조회하기
# https://school.programmers.co.kr/learn/courses/30/lessons/164673

select b.title, b.board_id, r.reply_id, r.writer_id, r.contents, date_format(r.created_date, '%Y-%m-%d') as created_date
from used_goods_board as b, used_goods_reply as r
where b.board_id = r.board_id and year(b.created_date) = 2022 and month(b.created_date) = 10
order by r.created_date, b.title;
