# PG 154540: 무인도 여행
# https://school.programmers.co.kr/learn/courses/30/lessons/154540

from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(maps, x, y):
    queue = deque()
    queue.append([x, y])

    sum = int(maps[x][y]) # 식량의 합
    maps[x][y] = 'X' # 방문 체크

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            mx = x + dx[i]
            my = y + dy[i]

            if mx < 0 or mx >= len(maps) or my < 0 or my >= len(maps[0]):
                continue

            if maps[mx][my] == 'X':
                continue

            # 연결되어 있으면 방문!
            sum += int(maps[mx][my])
            queue.append([mx, my])
            maps[mx][my] = 'X'

    return sum

def solution(maps):
    answer = []
    maps = [list(i) for i in maps] # 리스트 형태로 변환

    for i in range(len(maps)):
        for j in range(len(maps[0])):
            # 바다가 아닌 곳 방문
            if maps[i][j] != 'X':
                answer.append(bfs(maps, i, j))

    # 오름차순
    if len(answer) > 0:
        answer.sort()
    # 무인도가 없는 경우
    else:
        answer.append(-1)

    return answer