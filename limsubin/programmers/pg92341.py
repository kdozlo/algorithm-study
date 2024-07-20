# PG 92341: 주차 요금 계산
# https://school.programmers.co.kr/learn/courses/30/lessons/92341

import math

def solution(fees, records):
    dic = {}
    for record in records:
        # 문자열 파싱해서
        time, car, io = record.split(" ")
        # 시간 계산해주고 (h * 60 + m)
        time = int(time[:2]) * 60 + int(time[3:])
        # 딕셔너리에 넣는다!
        if car in dic:
            dic[car].append(time)
        else:
            dic[car] = [time]

    result = {}
    end = 23 * 60 + 59 # 끝나는 시간 (23:59)
    for car in dic:
        time = 0
        l = len(dic[car])
        # 앞에서부터 2개씩 보는데
        for i in range(0, l, 2):
            # out - in
            if i + 1 < l:
                time += dic[car][i + 1] - dic[car][i]
            # 뒤에 더이상 없으면 출차된 내역이 없는 것 -> 23:59 - in
            else:
                time += end - dic[car][i]
        # 기본 요금
        result[car] = fees[1]
        # 기본 시간 초과했을 때 단위 요금 더해주기
        if time > fees[0]:
            result[car] += math.ceil((time - fees[0]) / fees[2]) * fees[3]

    answer = []
    # 차량 번호가 작은 자동차부터
    for key in sorted(result.keys()):
        # 주차 요금을 차례대로 정수 배열에 담는다.
        answer.append(result[key])
    return answer