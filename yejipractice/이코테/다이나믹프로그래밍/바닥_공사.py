import sys
input = sys.stdin.readline

n = int(input())
mod = 796796
dp = [0]*(1000+1+1)

dp[1] = 1
dp[2] = 3


for i in range(3, n+1):
    dp[i] = ((2*dp[i-2])+dp[i-1]) % mod

print(dp[n])

# n이 1, 2인 경우는 for문 범위에 안 속하므로 안 돌아가는 거 잊지 않기
