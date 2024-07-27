# BOJ 2036: 수열의 점수
# https://www.acmicpc.net/problem/2036

import sys
import heapq

def input():
    return sys.stdin.readline().strip()

def sum(heap, flag):
    result = 0

    while len(heap) >= 2:
        # 2개씩 꺼내서
        a = heapq.heappop(heap)
        b = heapq.heappop(heap)
        # 곱하기!
        result += a * b

    # 끝에 하나 남았을 때
    if heap:
        return result + flag * heapq.heappop(heap)

    return result

plus = [] # 양수
minus = [] # 음수
answer = 0

n = int(input())
for _ in range(n):
    i = int(input())
    if i <= 0:
        heapq.heappush(minus, i)
    elif i == 1:
        answer += 1 # 1은 다른 수랑 곱하는 것보다 따로 더하는게 더 크다.
    else:
        heapq.heappush(plus, -i)

answer += sum(plus, -1) + sum(minus, 1)
print(answer)