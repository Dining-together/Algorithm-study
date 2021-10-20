from collections import deque

def is_in_range(x,y,n,m):
    return x>=0 and x<n and y>=0 and y<m

dx,dy=[0,0,-1,1],[1,-1,0,0]
n,m=map(int,input().split())
maze=[list(map(int,input())) for _ in range(n)]

queue=deque()
queue.append((0,0))

while queue:
    x,y=queue.popleft()

    if(x==n-1 and y==m-1):
        break

    for i in range(4):
        nx,ny=x+dx[i],y+dy[i]
        if is_in_range(nx,ny,n,m)==False:
            continue
        if maze[nx][ny]==0:
            continue
        maze[nx][ny]=maze[x][y]+1
        queue.append((nx,ny))

print(maze[n-1][m-1])