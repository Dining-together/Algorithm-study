from itertools import combinations
import sys
input = sys.stdin.readline

n = int(input())
nums = list(map(int, input().split()))
nums.sort()

target = 1
for i in nums:
    if target < i:
        break
    target += i

print(target)

# 5원 이상의 동전들만 있다면 4를 만들 수 없다 << 여기서 4가 target
