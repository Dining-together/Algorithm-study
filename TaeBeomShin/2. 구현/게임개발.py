dx,dy=[-1,0,1,0],[0,1,0,-1]

n,m=map(int,input().split())
x,y,direction=map(int,input().split())

array,visited=[],[]

for _ in range(n):
    arr=list(map(int,input().split()))
    visit=[0 for i in range(m)]
    array.append(arr)
    visited.append(visit)

while(True):
    flag=False
    visited[x][y]=1

    for i in range(4):
        nx,ny=x+dx[(direction-i+4)%4],y+dy[(direction-i+4)%4]
        if(array[nx][ny]==0 and visited[nx][ny]==0):
            direction=(direction-i+4)%4
            x,y=x+dx[direction],y+dy[direction]
            flag=True
            break

    if(flag==False):
        direction=(direction+1)%4
        nx,ny=x-dx[direction],y-dy[direction]
        if(array[nx][ny]==1):
            break
        else:
            x,y=nx,ny

ans=0

for i in range(len(visited)):
    ans+=visited[i].count(1)

print(ans)