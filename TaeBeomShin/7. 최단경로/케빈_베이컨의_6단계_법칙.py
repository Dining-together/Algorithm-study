INF=int(1e9)

n,m=map(int,input().split())

graph=[[INF]*(n+1) for _ in range(n+1)]

for i in range(1,n+1):
    for j in range(1,n+1):
        if i==j:
            graph[i][j]=0

for _ in range(m):
    x,y=map(int,input().split())
    graph[x][y]=1
    graph[y][x]=1

for k in range(1,n+1):
    for a in range(1,n+1):
        for b in range(1,n+1):
            graph[a][b]=min(graph[a][b],graph[a][k]+graph[k][b])

ans,idx=1e9,-1
for a in range(1,n+1):
    count=0
    for b in range(1,n+1):
        count+=graph[a][b]
    if(count<ans):
        ans=count
        idx=a

print(idx)