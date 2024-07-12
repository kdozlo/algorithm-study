# BOJ 2607: 비슷한 단어
# https://www.acmicpc.net/problem/2607

import sys

def input():
    return sys.stdin.readline().strip()

n = int(input())
first = list(input())

answer = 0
for i in range(n-1):
    word = list(input())

    if abs(len(word) - len(first)) > 1:
        continue

    if abs(len(set(word) - set(first))) > 1:
        continue

    cur = word[:]
    target = first[:]
    for w in word:
        # 첫 번째 단어와 같은 단어 지우기
        if w in target:
            target.remove(w)
            cur.remove(w)

    if len(target) <= 1 and len(cur) <= 1:
        answer += 1

print(answer)
