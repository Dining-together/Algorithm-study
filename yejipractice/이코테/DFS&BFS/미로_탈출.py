from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
maps = []
for _ in range(n):
    maps.append(list(map(int, input().rstrip("\n"))))

visited = [[0 for i in range(m)]for j in range(n)]
visited[0][0] = 1


def bfs(start1, start2):
    queue = deque([[start1, start2]])
    while queue:
        ss1, ss2 = queue.popleft()
        cases = [[ss1, ss2+1], [ss1, ss2-1], [ss1+1, ss2], [ss1-1, ss2]]
        for c in cases:
            s1, s2 = c
            if s1 >= 0 and s1 < n and s2 >= 0 and s2 < m:
                if maps[s1][s2] == 1 and visited[s1][s2] == 0:
                    visited[s1][s2] = visited[ss1][ss2] + 1
                    queue.append([s1, s2])


bfs(0, 0)
print(visited[n-1][m-1])
