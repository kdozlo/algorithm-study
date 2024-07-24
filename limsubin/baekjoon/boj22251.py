# BOJ 22251: 빌런 호석
# https://www.acmicpc.net/problem/22251

def count_diff(x, y):
    cnt = 0
    for i in range(7):
        cnt += abs(x[i] - y[i])
    return cnt

led = [[1, 1, 1 ,1, 0, 1, 1],
       [0, 0, 1, 0, 0, 1, 0],
       [0, 1, 1, 1, 1, 0, 1],
       [0, 1, 1, 0, 1, 1, 1],
       [1, 0, 1, 0, 1, 1, 0],
       [1, 1, 0, 0, 1, 1, 1],
       [1, 1, 0, 1, 1, 1, 1],
       [0, 1, 1, 0, 0, 1, 0],
       [1, 1, 1, 1, 1, 1, 1],
       [1, 1, 1, 0, 1, 1, 1]]

n, k, p, x = map(int, input().split())

diff = [[0] * 10 for _ in range(10)]
# i -> j 변환 횟수
for i in range(10):
    for j in range(10):
        diff[i][j] += count_diff(led[i], led[j])

answer = 0
xx = list(map(int, str(x).zfill(k))) # 초기 LED 상태

for y in range(1, n+1):
    # 같은 수 지나감!
    if x == y:
        continue

    yy = list(map(int, str(y).zfill(k))) # 바꿀 LED 상태

    cnt = 0
    for i in range(k):
        cnt += diff[xx[i]][yy[i]]
        if cnt > p:
            break
    else:
        answer += 1

print(answer)