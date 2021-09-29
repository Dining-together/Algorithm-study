import sys
input = sys.stdin.readline

N, M = map(int, input().split())
balls = list(map(int, input().split()))

count = 0
for i in range(N):
    for j in range(i+1, N):
        if balls[i] != balls[j]:
            count += 1

print(count)
