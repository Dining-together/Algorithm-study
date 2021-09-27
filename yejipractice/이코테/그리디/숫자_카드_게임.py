import sys
input = sys.stdin.readline

N, M = map(int, input().split())
nums = []

for _ in range(N):
    nums.append(min(list(map(int, input().split()))))

print(max(nums))
