from collections import deque
import sys
input = sys.stdin.readline

n, m, k, x = map(int, input().split())
maps = [[] for i in range(n+1)]
for _ in range(m):
    one, two = map(int, input().split())
    maps[one].append(two)

visited = [-1]*(n+1)


def bfs(start):
    queue = deque([start])
    visited[start] = 0
    while queue:
        now = queue.popleft()
        for mn in maps[now]:
            if visited[mn] == -1:
                queue.append(mn)
                visited[mn] = visited[now]+1
    answer = []
    for i in range(len(visited)):
        if visited[i] == k:
            answer.append(i)
    if answer == []:
        print(-1)
    else:
        for i in answer:
            print(i)


bfs(x)
