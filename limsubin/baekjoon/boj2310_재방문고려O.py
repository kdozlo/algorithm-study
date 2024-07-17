# BOJ 2310: 어드벤처 게임
# https://www.acmicpc.net/problem/2310

import sys

def input():
    return sys.stdin.readline().strip()

def dfs(x, money):
    global answer

    if answer == 'Yes':
        return

    # 도착!
    if x == n:
        answer = "Yes"
        return

    visited[x] = money

    # 문이 없음
    if len(miro[x]) <= 2:
        return

    for i in miro[x][2:]:
        i = int(i)
        m = int(miro[i][1])

        # 소지금 일정량 유지
        if miro[i][0] == 'L':
            m = max(money, m)
        # 통행료 지급
        elif miro[i][0] == 'T':
            if money - m >= 0:
                m = money - m
            else:
                continue
        else:
            m = money

        # 이미 최적으로 들어간 곳!
        if visited[i] >= m:
            continue

        dfs(i, m)

while True:
    n = int(input())

    # 미로의 방 수가 0개인 입력이 들어오면 입력을 종료
    if n == 0:
        break

    miro = [[]] + [list(input().split()[:-1]) for _ in range(n)]
    visited = [-1] * (n + 1)
    answer = "No"
    dfs(1, 0)

    print(answer)