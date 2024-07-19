# BOJ 22251: 빌런 호석
# https://www.acmicpc.net/problem/22251

def is_changeable(x, y, p):
    cnt = 0
    for i in range(k):
        for j in range(7):
            if x[i][j] != y[i][j]:
                cnt += 1
                if cnt > p:
                    return False
    if cnt < 1:
        return False
    return True

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

answer = 0
led_x = [led[int(i)] for i in str(x).zfill(k)] # 초기 LED 상태

for y in range(1, n+1):
    # 같은 수 지나감!
    if x == y:
        continue

    led_y = [led[int(i)] for i in str(y).zfill(k)] # 바꿀 LED 상태

    # 두 수의 차이가 1 이상 p 이하일 경우!
    if is_changeable(led_x, led_y, p):
        answer += 1

print(answer)