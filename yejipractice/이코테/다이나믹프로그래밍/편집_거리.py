import sys
input = sys.stdin.readline

str1 = input().rstrip()
str2 = input().rstrip()


def edit_dist(str1, str2):
    n = len(str1)
    m = len(str2)

    dp = [[0] * (m + 1) for _ in range(n + 1)]

    for i in range(1, n + 1):
        dp[i][0] = i
    for j in range(1, m + 1):
        dp[0][j] = j

    for i in range(1, n+1):
        for j in range(1, m+1):
            if str1[i-1] == str2[j-1]:
                dp[i][j] = dp[i-1][j-1]
            else:
                dp[i][j] = 1 + min(dp[i][j - 1], dp[i - 1]
                                   [j], dp[i - 1][j - 1])

    return dp[n][m]


print(edit_dist(str1, str2))


# 최소 편집 거리(Edit Distance) 계산을 위한 다이나믹 프로그래밍(최소 편집 거리 알고리즘)
# https://www.youtube.com/watch?v=We3YDTzNXEk
