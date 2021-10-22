def dfs(x,y):
    dx,dy=[-1,0,1,1,1,0,-1,-1],[-1,-1,-1,0,1,1,1,0]

    board[x][y]=0
    for i in range(8):
        nx=x+dx[i]
        ny=y+dy[i]
        if 0<=nx<h and 0 <=ny<w and board[nx][ny]==1:
            dfs(nx,ny)

while True:
    w,h=map(int,input().split())
    if w==0 and h==0:
        break
    board=[]
    count=0
    for _ in range(h):
        board.append(list(map(int,input().split())))
    for i in range(h):
        for j in range(w):
            if board[i][j]==1:
                dfs(i,j)
    print(count)
