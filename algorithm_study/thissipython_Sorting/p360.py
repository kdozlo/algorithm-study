import sys
import math
input = lambda: sys.stdin.readline().rstrip()

n = int(input())

arry = list(map(int, input().split()))

arry = sorted(arry)

print(arry[(n - 1) // 2])