# PG 181188: 요격 시스템
# https://school.programmers.co.kr/learn/courses/30/lessons/181188

def solution(targets):
    targets.sort(key=lambda x: (x[0], x[1])) # 시작점 기준 오름차순 -> 끝점 기준 오름차순

    answer = 1
    temp = targets[0][1] # 현재 미사일을 요격할 수 있는 위치의 최댓값

    for target in targets[1:]:
        # 현재 위치 범위 밖에 있는 경우
        if target[0] >= temp:
            # 타겟 변경
            temp = target[1]
            answer += 1
        # 현재 위치 범위 안에 있는 경우
        else:
            # 쌓인 미사일을 함께(?) 요격할 수 있는 위치의 최댓값
            temp = min(temp, target[1])

    return answer
