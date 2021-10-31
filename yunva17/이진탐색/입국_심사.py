# 3079
import sys
input = sys.stdin.readline

n, m = map(int, input().split())

time = []
for _ in range(n):
    time.append(int(input()))

start = 0
end = max(time) * m

result = 0

while start<=end:
    total = 0 
    mid = (start+end)//2

    for i in range(n):
        total+=mid//time[i]
    
    if total<m:
        start=mid+1
    else:
        result = mid
        end = mid-1

print(result)
