import sys
input = sys.stdin.readline

N, K = map(int, input().split())

count = 0
while N:
    if N % K == 0:
        N //= K
        count += 1
    else:
        count += N % K
        N -= N % K

print(count-1)
