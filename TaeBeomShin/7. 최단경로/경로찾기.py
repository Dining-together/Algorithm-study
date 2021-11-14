INF=int(1e9)

n=int(input())

graph=[[INF]*(n+1) for _ in range(n+1)]

for a in range(1,n+1):
    for b in range(1,n+1):
        if a==b:
            graph[a][b]=0
board=[list(map(int,input().split())) for _ in range(n)]

for i in range(n):
    for j in range(n):
        if(board[i][j]==1):
            graph[i+1][j+1]=1

for k in range(1,n+1):
    for a in range(1,n+1):
        for b in range(1,n+1):
            graph[a][b]=min(graph[a][b],graph[a][k]+graph[k][b])

for i in range(1,n+1):
    for j in range(1,n+1):
        if(graph[i][j]!=INF):
            print(1,end=" ")
        else:
            print(0,end=" ")
    print()