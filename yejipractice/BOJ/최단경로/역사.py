INF = int(1e9)
N, M = map(int, input().split())

graph = [[INF] * (N + 1) for _ in range(N + 1)]

for i in range(M):
    A, B = map(int, input().split())
    graph[A][B] = 1

for i in range(1, N + 1):
    for j in range(1, N + 1):
        if i == j:
            graph[i][j] = 0

for i in range(1, N + 1):
    for j in range(1, N + 1):
        for k in range(1, N + 1):
            graph[j][k] = min(graph[j][k], graph[j][i] + graph[i][k])

tc = int(input())
for _ in range(tc):
    a, b = map(int, input().split())
    res1 = graph[a][b]
    res2 = graph[b][a]
    if res1 == INF and res2 == INF:
        print(0)
    elif res1 < res2:
        print(-1)
    elif res1 > res2:
        print(1)
