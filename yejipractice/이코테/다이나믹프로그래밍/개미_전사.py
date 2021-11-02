import sys
input = sys.stdin.readline

n = int(input())
nums = [0]+list(map(int, input().split()))

for i in range(3, n+1):
    nums[i] = max(nums[i-2]+nums[i], nums[i-1])

print(max(nums))
