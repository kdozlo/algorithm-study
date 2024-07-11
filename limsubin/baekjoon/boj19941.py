# BOJ 19941: 햄버거 분배
# https://www.acmicpc.net/problem/19941

import sys

def input():
    return sys.stdin.readline().strip()

n, k = map(int, input().split()) # 식탁의 길이, 햄버거를 선택할 수 있는 거리
position = list(input()) # 사람과 햄버거의 위치

visited = [False] * n # 방문 체크 리스트
answer = 0 # 햄버거를 먹을 수 있는 최대 사람 수

# 앞에서부터 'H' 탐색 -> 거리 K 이내에서 'P'를 찾는다.
for i in range(n):
    if position[i] != 'H':
        continue
    # 햄버거 탐색
    for j in range(i-k, i+k+1): # 앞뒤 범위 k
        # 리스트의 범위를 벗어나는 경우
        if j < 0 or j >= n:
            continue
        # 앞에서부터 햄버거를 아직 먹지 않은 사람 찾기
        if position[j] == 'P' and not visited[j]:
            visited[j] = True
            answer += 1
            break

print(answer)
