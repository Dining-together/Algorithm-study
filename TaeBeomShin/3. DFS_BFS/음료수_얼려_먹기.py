n,m=map(int,input().split())

graph= [list(map(int,input())) for _ in range(n)]

def is_in_range(x,y,n,m):
    return x>=0 and x<n and y>=0 and y<m

def dfs(x,y):
    if is_in_range(x,y,n,m)==False:
        return False
    if graph[x][y]==0:
        graph[x][y]=1
        dfs(x-1,y)
        dfs(x,y-1)
        dfs(x+1,y)
        dfs(x,y+1)
        return True
    return False

result=0
for i in range(n):
    for j in range(m):
        if(dfs(i,j)==True):
            result+=1

print(result)