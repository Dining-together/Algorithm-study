import sys
input = sys.stdin.readline

n = int(input())
nums = list(map(int, input().split()))

start = 0
end = n-1

answer = -1
while start <= end:
    mid = (start+end)//2
    if mid == nums[mid]:
        answer = mid
        break
    if mid < nums[mid]:
        end = mid - 1
    else:
        start = mid + 1

print(answer)
