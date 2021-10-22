from collections import deque
import sys

input=sys.stdin.readline
m,n,h=map(int,input().split())
board,queue=[],deque([])

for _ in range(h):
    tmp=[]
    for j in range(n):
        tmp.append(list(map(int,input().split())))
    board.append(tmp)

for i in range(h):
    for j in range(n):
        for k in range(m):
            if(board[i][j][k]==1):
                queue.append([i,j,k])

def bfs():
    dx,dy,dz=[0,0,1,-1,0,0],[1,-1,0,0,0,0],[0,0,0,0,1,-1]

    while queue:
        x,y,z=queue.popleft()

        for i in range(6):
            nx,ny,nz=x+dx[i],y+dy[i],z+dz[i]
            if nx<0 or nx>=h or ny<0 or ny>=n or nz<0 or nz>=m:
                continue
            if board[nx][ny][nz]==0:
                board[nx][ny][nz]=board[x][y][z]+1
                queue.append((nx,ny,nz))

ans=0
bfs()

for b in board:
    for l in b:
        for k in l:
            if k==0:
                print(-1)
                exit(0)
        ans=max(ans,max(l))

print(ans-1)