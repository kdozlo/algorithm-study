# BOJ 3079: 입국심사
# https://www.acmicpc.net/problem/3079

import sys

def input():
    return sys.stdin.readline().strip()

n, m = map(int, input().split())

time = []
start = float('INF')

for _ in range(n):
    i = int(input())
    time.append(i)
    start = min(start, i) # 시간의 최솟값

end = start * m # 최솟값 m번

while start <= end:
    mid = (start + end) // 2

    # 심사를 받을 수 있는 사람의 수 세기
    temp = 0
    for t in time:
        temp += mid // t

        # m명이 모두 심사 받을 수 있는 경우
        if temp >= m:
            end = mid - 1
            break
    # 심사 받을 수 없는 경우
    else:
        start = mid + 1

print(start)