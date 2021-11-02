from bisect import bisect_left
import sys
input = sys.stdin.readline

n = int(input())
k = int(input())

start, end = 1, k

while start <= end:
    mid = (start+end) // 2

    sum = 0
    for i in range(1, n+1):
        sum += min(mid//i, n)

    if sum >= k:
        answer = mid
        end = mid - 1
    else:
        start = mid + 1

print(answer)

# https://claude-u.tistory.com/449
