from collections import deque
dx,dy=[-1,0,1,1,1,0,-1,-1],[-1,-1,-1,0,1,1,1,0]

def out_of_range(x,y,w,h):
    return x<0 or x>=h or y<0 or y>=w

while True:
    w,h=map(int,input().split())
    if(w==0 and h==0):
        break
    board=[]
    for _ in range(h):
        board.append(list(map(int,input().split())))
    visit=[[0 for _ in range(w)] for _ in range(h)]
    count=0
    for i in range(h):
        for j in range(w):
            if(board[i][j]==0 or visit[i][j]):
                continue
            q=deque()
            q.append((i,j))
            count+=1
            while q:
                cur=q.popleft()
                cx,cy=cur[0],cur[1]
                for k in range(8):
                    nx,ny=cx+dx[k],cy+dy[k]
                    if(out_of_range(nx,ny,w,h) or board[nx][ny]==0):
                        continue
                    if(visit[nx][ny]):
                        continue
                    q.append((nx,ny))
                    visit[nx][ny]=1
    print(count)