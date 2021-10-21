from itertools import combinations
import copy

def out(x,y,n):
    return x<0 or x>=n or y<0 or y>=n

dx,dy=[1,-1,0,0],[0,0,1,-1]
n,emptys,teachers=int(input()),[],[]
board=[list(input().split()) for _ in range(n)]

for i in range(n):
    for j in range(n):
        if(board[i][j]=='T'):
            teachers.append((i,j))
        elif(board[i][j]=='X'):
            emptys.append((i,j))

emptys.sort()
num,ans=sum([s.count('S') for s in board]),False

for b in list(combinations(emptys,3)):
    nb=copy.deepcopy(board)
    for i in range(3):
        nb[b[i][0]][b[i][1]]='O'
    for t in teachers:
        for j in range(4):
            x,y=t[0],t[1]
            while(True):
                if(out(x,y,n) or nb[x][y]=='O'):
                    break
                else:
                    nb[x][y]='X'
                    x,y=x+dx[j],y+dy[j]
    if(num==sum([s.count('S') for s in nb])):
        ans=True
        break

if(ans):
    print("YES")
else:
    print("NO")
