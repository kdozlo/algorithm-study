# BOJ 9017: 크로스 컨트리
# https://www.acmicpc.net/problem/9017

import sys
from collections import defaultdict

def input():
    return sys.stdin.readline().strip()

t = int(input())

for _ in range(t):
    n = int(input())
    info = list(map(int, input().split()))

    # 팀 별 참가자 수 저장
    team = defaultdict(int)
    for i in range(n):
        team[info[i]] += 1

    # 팀 별 점수 계산
    s = 0
    score = {}
    for i in range(n):
        # 참가자가 6명 미만인 팀 제외
        if team[info[i]] < 6:
            continue

        # 점수 저장
        s += 1
        if info[i] in score:
            score[info[i]].append(s)
        else:
            score[info[i]] = [s]

    best = float('INF')
    for i in score:
        cur = sum(score[i][:4])

        # 상위 4명 점수의 합이 가장 낮은 팀이 우승
        if cur < best:
            answer = i
            best = cur
            continue
        # 동점일 경우
        if cur == best:
            # 다섯 번째 주자가 가장 빨리 들어온 팀이 우승
            if score[i][4] < score[answer][4]:
                answer = i
                continue

    print(answer)
