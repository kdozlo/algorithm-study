# BOJ 2240: 자두나무
# https://www.acmicpc.net/problem/2240

t, w = map(int, input().split())
tree = [0] + [int(input()) for _ in range(t)]

result = [[0] * (t+1) for _ in range(w+1)]

# 초기값 (이동 X)
for j in range(1, t+1):
    result[0][j] = result[0][j-1] + tree[j] % 2

for i in range(1, w+1):
    for j in range(1, t+1):
        result[i][j] = max(result[i][j-1], result[i-1][j-1])

        # 현재 위치 (2의 배수 만큼 이동했으면 1, 아니면 2)
        cur = 1 if i % 2 == 0 else 2
        # 현재 위치에서 자두가 떨어지고 있는 경우
        if tree[j] == cur:
            result[i][j] += 1

answer = 0
for i in range(w+1):
    answer = max(answer, result[i][-1])

print(answer)
