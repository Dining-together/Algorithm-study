# 백준 11047번
import sys
input = sys.stdin.readline

n, k = map(int, input().split())
types = []
for _ in range(n):
    types.append(int(input()))

types.sort(reverse=True)

count = 0
for t in types:
    if t <= k:
        count += k // t
        k = k % t

print(count)
