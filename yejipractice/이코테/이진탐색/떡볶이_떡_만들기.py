import sys
input = sys.stdin.readline

n, need = map(int, input().split())
nums = list(map(int, input().split()))

start = 0
end = max(nums)

result = 0
while start <= end:
    total = 0
    mid = (start+end) // 2
    for num in nums:
        if num > mid:
            total += num - mid
    if total < need:
        end = mid - 1
    else:
        result = mid
        start = mid + 1

print(result)
