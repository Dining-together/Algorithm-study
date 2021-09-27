import sys
input = sys.stdin.readline

N, M, K = map(int, input().split())

nums = list(map(int, input().split()))
nums.sort(reverse=True)

# (가장 큰 수 * K + 두 번째로 큰 수) * a

second = M // (K+1)  # 두 번째로 큰 수 개수
first = K * second + M % (K+1)  # 가장 큰 수 개수

print(nums[0]*first+nums[1]*second)
