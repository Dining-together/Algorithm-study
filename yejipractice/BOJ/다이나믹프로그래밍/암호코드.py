import sys
input = sys.stdin.readline

num = list(map(str, input().rstrip()))
dp = [0]*(len(num)+1)
dp[0] = 1
mod = 1000000

if num[0] == "0":
    dp[1] = 0
else:
    dp[1] = 1

for i in range(2, len(num)+1):
    if 0 < int(num[i-1]):
        dp[i] = dp[i-1]
    if 10 <= int(num[i-2]+num[i-1]) <= 26:
        dp[i] += dp[i-2]

print(dp[-1] % mod)

# 로직은 맞았는데 구현에서 약간의 실수, 다시 풀어보기
# 0 고려
