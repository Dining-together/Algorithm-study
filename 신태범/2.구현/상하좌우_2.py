def can_go(cx,cy,n):
    return (cx>0 and cy>0 and cx<=n and cy<=n)

n=int(input())
commands=input().split()

x,y=1,1
dx,dy,move_types=[0,0,-1,1],[-1,1,0,0],{'L':0,'R':1,'U':2,'D':3}

for command in commands:
    nx,ny=x+dx[move_types[command]],y+dy[move_types[command]]
    if(can_go(nx,ny,n)):
        x,y=nx,ny

print(x,y)
