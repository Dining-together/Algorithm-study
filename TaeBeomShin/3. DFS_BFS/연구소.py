import copy
from collections import deque
from itertools import combinations

dx,dy=[0,0,1,-1],[1,-1,0,0]

def out_of_range(x,y,n,m):
    return x<0 or x>=n or y<0 or y>=m

def bfs(v,board,n,m):
    x,y=v[0],v[1]
    q=deque()
    q.append((x,y))
    board[x][y]=-1

    while q:
        cx,cy=q.popleft()
        board[cx][cy]=-1

        for i in range(4):
            nx,ny=cx+dx[i],cy+dy[i]
            if(out_of_range(nx,ny,n,m)):
                continue
            if(board[nx][ny]==0):
                q.append((nx,ny))
                board[nx][ny]=2

if __name__ == "__main__":

    n,m=map(int,input().split())
    board=[list(map(int,input().split())) for _ in range(n)]
        
    empty,virus,ans=[],[],0

    for i in range(n):
        for j in range(m):
            if(board[i][j]==0):
                empty.append((i,j))
            if(board[i][j]==2):
                virus.append((i,j))

    empty.sort()

    blocks=list(combinations(empty,3))
    for b in blocks:
        new_board=copy.deepcopy(board)
        #1. 벽을 3개 세운다.
        for i in range(3):
            new_board[b[i][0]][b[i][1]]=1
        
        #2. bfs로 바이러스를 퍼뜨린다.
        for v in virus:
            bfs(v,new_board,n,m)

        #3. 안전영역의 개수를 센다
        ans=max(ans,sum(line.count(0) for line in new_board))

    print(ans)