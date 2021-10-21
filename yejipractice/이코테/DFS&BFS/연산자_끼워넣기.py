from collections import deque
from itertools import permutations
import sys
input = sys.stdin.readline

n = int(input())
nums = list(map(int, input().split()))
ops = list(map(int, input().split()))
rops = ["+"]*ops[0]+["-"]*ops[1]+["*"]*ops[2]+["/"]*ops[3]
cases = list(set(list(permutations(rops))))

min_n = 1000000001
max_n = -1000000001

for case in cases:
    sum = nums[0]
    for i in range(1, n):
        o = case[i-1]
        b = nums[i]
        if o == "+":
            sum += b
        elif o == "-":
            sum -= b
        elif o == "*":
            sum *= b
        else:
            if sum >= 0:
                sum //= b
            else:
                sum = -((-sum) // b)
    max_n = max(sum, max_n)
    min_n = min(sum, min_n)

print(max_n)
print(min_n)
