'''
=를 ==로 잘못써서 틀릴뻔함;; 실수하지 말기.
'''
dx,dy,words=[-1,0,1,0],[0,1,0,-1],{'D':1,'L':-1}

def is_in_range(x,y,n):
    return x>=0 and x<n and y>=0 and y<n

n=int(input())
k=int(input())
board,commands=[[0 for i in range(n)] for j in range(n)],{}

for _ in range(k):
    r,c=map(int,input().split())
    board[r-1][c-1]=1

m=int(input())

for _ in range(m):
    time,command=input().split()
    commands[int(time)]=command

length,dir,baam,ans=1,1,[[0,0]],0

while True:
    if(commands.get(ans,False)):
        dir=(dir+words[commands.get(ans)]+4)%4
    
    nx,ny=baam[0][0]+dx[dir],baam[0][1]+dy[dir]
    ans+=1

    #벽에 부딪히는 경우
    if(is_in_range(nx,ny,n)==False):    
        break
    #자기 자신에 부딪히는 경우
    if([nx,ny] in baam):
        break
    #이동한 칸에 사과가 있다면
    if(board[nx][ny]==1):
        board[nx][ny]=0
        baam.insert(0,[nx,ny])
        length+=1
    else:
        baam.insert(0,[nx,ny])
        baam.pop()
print(ans)
