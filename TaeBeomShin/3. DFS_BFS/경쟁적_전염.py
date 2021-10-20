# 우선순위 큐를 이용하면 더 비효율적..
from collections import deque

dx,dy=[0,0,-1,1],[-1,1,0,0]

def out_of_range(x,y,n):
    return x<0 or x>=n or y<0 or y>=n

n,k=map(int,input().split())
board=[list(map(int,input().split())) for _ in range(n)]
S,X,Y=map(int,input().split())

data=[]

for i in range(n):
    for j in range(n):
        if(board[i][j]>0):
            data.append((board[i][j],0,(i,j)))

data.sort()
q=deque(data)

while q:
    cur=q.popleft()
    v,s,cx,cy=cur[0],cur[1],cur[2][0],cur[2][1]
    if(s==S):
        break
    for i in range(4):
        nx,ny=cx+dx[i],cy+dy[i]
        if(out_of_range(nx,ny,n)):
            continue
        if(board[nx][ny]==0):    
            board[nx][ny]=v
            q.append((v,s+1,(nx,ny)))

print(board[X-1][Y-1])