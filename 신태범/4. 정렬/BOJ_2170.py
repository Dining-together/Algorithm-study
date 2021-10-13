import sys
input=sys.stdin.readline

n=int(input())
lines=sorted([tuple(map(int,input().split())) for _ in range(n)])
x,y,ans=lines[0][0],lines[0][1],0

for nx,ny in lines:
    if(y<nx):
        ans+=(y-x)
        x,y=nx,ny
        continue
    y=max(y,ny)

print(ans+(y-x))
