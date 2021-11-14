# 1389
INF = int(1e9)

n,m = map(int,input().split())
graph = [[INF]*(n+1) for _ in range(n+1)]

for a in range(1,n+1):
    for b in range(1,n+1):
        if a==b:
            graph[a][b]=0

for _ in range(m):
    a,b=map(int, input().split())
    graph[a][b], graph[b][a]=1,1
    

for k in range(1,n+1):
    for a in range(1,n+1):
        for b in range(1,n+1):
            graph[a][b] = min(graph[a][b], graph[a][k]+graph[k][b])
            
result,index = INF
for i in range(len(graph)):
    if sum(graph[i]) < result:
        result = sum(graph[i])
        index = i
print(index+1)