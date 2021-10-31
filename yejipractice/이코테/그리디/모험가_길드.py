import sys
input = sys.stdin.readline


n, nums = int(input()), list(map(int, input().split()))
nums.sort()

result = 0
count = 0

# 같은 로직인데 더 간단한 방법
for i in nums:
    count += 1
    if count >= i:
        result += 1
        count = 0

print(result)
