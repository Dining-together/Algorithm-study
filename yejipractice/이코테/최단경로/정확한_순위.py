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

answer = 0
for i in range(1, N+1):
    count = 0
    for j in range(1, N+1):
        if graph[i][j] != INF:
            count += 1
    if count == N-1:
        answer += 1

print(answer)
