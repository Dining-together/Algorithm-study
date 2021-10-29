import sys
input = sys.stdin.readline

n, target = map(int, input().split())
nums = list(map(int, input().split()))

start = max(nums)
end = sum(nums)

ans = end
while start <= end:
    mid = (start+end)//2

    count = 0
    sum = 0
    for num in nums:
        if sum + num > mid:
            count += 1
            sum = 0
        sum += num
    count += 1 if sum else 0

    if count <= target:
        ans = min(ans, mid)
        end = mid - 1
    else:
        start = mid + 1

print(ans)

# https://haerang94.tistory.com/144
