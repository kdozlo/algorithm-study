# BOJ 1515: 수 이어 쓰기
# https://www.acmicpc.net/problem/1515

num = list(input())

idx = 0
answer = 1
flag = False

while True:
    temp = str(answer)

    # 현재 숫자가 비교할 수에 포함이 되어 있는 경우
    while num[idx] in temp:
        # 포함되어 있는 인덱스 찾기
        i = temp.find(num[idx])

        # 다음 숫자
        idx += 1

        # 모든 숫자의 탐색을 마친 경우 정답!
        if idx >= len(num):
            flag = True
            break

        # 현재 숫자가 비교할 수의 마지막 숫자인 경우
        if i == len(temp) - 1:
            break

        # 해당 인덱스 다음부터 탐색
        temp = temp[i+1:]

    if flag:
        break

    answer += 1

print(answer)