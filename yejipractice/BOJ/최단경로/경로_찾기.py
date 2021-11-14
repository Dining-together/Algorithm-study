import sys
input = sys.stdin.readline
INF = int(1e9)
n = int(input())
inputs = []
for _ in range(n):
    inputs.append(list(map(int, input().split())))

graph = [[INF] * (n) for _ in range(n)]

for i in range(n):
    for j in range(n):
        if inputs[i][j] == 1:
            graph[i][j] = 1

for k in range(n):
    for a in range(n):
        for b in range(n):
            graph[a][b] = min(graph[a][b], graph[a][k]+graph[k][b])

for i in range(n):
    for j in range(n):
        if graph[i][j] != INF:
            print(1, end=" ")
        else:
            print(0, end=" ")
    print()
