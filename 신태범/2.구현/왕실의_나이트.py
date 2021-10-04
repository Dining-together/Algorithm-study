def can_go(x,y):
    return (x>=1 and y>=1 and x<=8 and y<=8)

n=input()

x,y,ans=int(n[1]),ord(n[0])-ord('a')+1,0
dx,dy=[1,2,2,1,-1,-2,-2,-1],[2,1,-1,-2,2,1,-1,-2]

for i in range(8):
    if(can_go(x+dx[i],y+dy[i])):
        ans+=1

print(ans)