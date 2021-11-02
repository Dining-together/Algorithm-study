#2606

from collections import deque

n = int(input())
m = int(input())


com = [[] for _ in range(n+1)]
visited = [False] * (n+1)
for _ in range(m):
    a, b = map(int, input().split())
    com[a].append(b)
    com[b].append(a) # 양방향구조

def bfs(x):
    queue = deque([x])
    while queue:
        v = queue.popleft()
        if visited[v] == False:
            visited[v] = True
            for c in com[v]:
                queue.append(c)

    result = 0
    for i in visited:
        if i == True:
            result+=1

    print(result-1) 
bfs(1)

