# PG 81302: 거리두기 확인하기
# https://school.programmers.co.kr/learn/courses/30/lessons/81302

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def find(p):
    for x in range(5):
        for y in range(5):
            if p[x][y] != 'P':
                continue

            # 응시자가 앉아있는 자리 확인
            for i in range(4):
                mx = x + dx[i]
                my = y + dy[i]

                if mx < 0 or mx >= 5 or my < 0 or my >= 5 or p[mx][my] == 'X':
                    continue

                # 거리두기가 지켜지지 않은 경우
                if p[mx][my] == 'P':
                    return 0

                for j in range(4):
                    mmx = mx + dx[j]
                    mmy = my + dy[j]

                    if mmx < 0 or mmx >= 5 or mmy < 0 or mmy >= 5:
                        continue

                    if mmx == x and mmy == y:
                        continue

                    # 거리두기가 지켜지지 않은 경우
                    if p[mmx][mmy] == 'P':
                        return 0

    return 1

def solution(places):
    answer = []
    for i in range(5):
        answer.append(find(places[i]))
    return answer