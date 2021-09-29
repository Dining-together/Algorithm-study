from itertools import combinations
import sys
input = sys.stdin.readline

n = int(input())
nums = list(map(int, input().split()))

cases = []
for i in range(1, n+1):
    a = list(combinations(nums, i))
    for aa in a:
        cases.append(sum(aa))

cases = list(set(cases))

for i in range(1, sum(nums)+1):
    if i in cases:
        print(i)
        break
