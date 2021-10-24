from collections import deque

n, m, k, x = map(int, input().split())

road = [[] for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    road[a].append(b)

# 최단거리
dis = [-1] * (n+1)
dis[x] = 0

result = []

def bfs(x):
    queue = deque([x])

    while queue:
        v = queue.popleft()
        for r in road[v]:
            if dis[r] == -1:
                queue.append(r)
                dis[r] = dis[v]+1

    for i in range(len(dis)):
        if dis[i] == k:
            result.append(i)
    if len(result) == 0:
        print(-1)
    else:
        for i in result:
            print(i)

bfs(x)
    



# 모든 간선의 비용이 동일할 때 -> 너비우선탐색 BFS
# == 모든 도로의 거리는 1이라는 조건





    
