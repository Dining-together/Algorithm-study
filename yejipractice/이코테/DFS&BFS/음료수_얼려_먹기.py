import sys
input = sys.stdin.readline

# 세로 n, 가로 m
n, m = map(int, input().split())
maps = []
for _ in range(n):
    maps.append(list(map(int, input().rstrip("\n"))))

visited = [[False for i in range(m)] for j in range(n)]


def dfs(start1, start2):
    if maps[start1][start2] == 1 or visited[start1][start2] == True:
        return False
    else:
        visited[start1][start2] = True
        cases = [[start1, start2+1], [start1, start2-1],
                 [start1+1, start2], [start1-1, start2]]
        for c in cases:
            s1, s2 = c
            if s1 >= 0 and s2 >= 0 and s1 < n and s2 < m:
                if maps[s1][s2] == 0 and visited[s1][s2] == False:
                    dfs(s1, s2)
        return True


count = 0
for i in range(n):
    for j in range(m):
        if dfs(i, j) == True:
            count += 1

print(count)
