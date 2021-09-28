import sys
input = sys.stdin.readline


n, nums = int(input()), list(map(int, input().split()))
nums.sort()

idx = 0
count = 0

while nums:
    length = len(nums)
    if idx+1 > length:
        break
    if nums[idx] == idx+1:
        nums = nums[idx+1:]
        idx = 0
        count += 1
    else:
        idx += 1

print(count)
