import sys
input = sys.stdin.readline

test = int(input())

for _ in range(test):
    n, m = map(int, input().split())
    data = list(map(int, input().split()))
    dp = []
    for i in range(0, len(data), m):
        dp.append(data[i:i+m])
    for j in range(1, m):
        for i in range(n):
            if i == 0:
                dp[i][j] += max(dp[i][j-1], dp[i+1][j-1])
            elif i == n-1:
                dp[i][j] += max(dp[i-1][j-1], dp[i][j-1])
            else:
                dp[i][j] += max(max(dp[i][j-1], dp[i+1][j-1]), dp[i-1][j-1])
    ans = dp[0][m-1]
    for i in range(1, n):
        ans = max(ans, dp[i][m-1])
    print(ans)
