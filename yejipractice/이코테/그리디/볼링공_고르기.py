import sys
input = sys.stdin.readline

N, M = map(int, input().split())
balls = list(map(int, input().split()))

array = [0] * 11
for b in balls:
    array[b] += 1

result = 0
for i in range(1, M+1):
    N -= array[i]
    result += array[i] * N

print(result)
