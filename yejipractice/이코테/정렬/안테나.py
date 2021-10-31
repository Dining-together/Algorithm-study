import sys
input = sys.stdin.readline

n = int(input())
nums = list(map(int, input().split()))
nums.sort()

print(nums[(len(nums)-1)//2])

# 각 원소들간의 거리 합의 최소를 구하기 위해서는 중간값 출력하면 된다.
