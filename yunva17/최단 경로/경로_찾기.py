# 11403

INF = int(1e9)

n = int(input())
graph = [[INF]*(n+1) for _ in range(n+1)]


lists = []
for _ in range(n):
    lists.append(list(map(int, input().split())))
    
for i in range(n):
    for j in range(n):
        if lists[i][j] ==1:
            graph[i][j]=1
            
for k in range(n):
    for a in range(n):
        for b in range(n):
            graph[a][b] = min(graph[a][b], graph[a][k]+graph[k][b])

for a in range(n):
    for b in range(n):
        if graph[a][b]!=INF:
            print(1, end=" ")
        else:
            print(0, end=" ")
            
    print()