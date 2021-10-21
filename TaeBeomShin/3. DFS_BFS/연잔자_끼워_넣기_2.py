m,M=1e9,-1e9

n=int(input())
A=list(map(int,input().split()))
a,b,c,d=map(int,input().split())

def dfs(v,i,d1,d2,d3,d4):
    global M,m
    if(i==n):
        m=min(m,v)
        M=max(M,v)
        return
    if d1: dfs(v+A[i],i+1,d1-1,d2,d3,d4)
    if d2: dfs(v-A[i],i+1,d1,d2-1,d3,d4)
    if d3: dfs(v*A[i],i+1,d1,d2,d3-1,d4)
    if d4: dfs(int(v/A[i]),i+1,d1,d2,d3,d4-1)

dfs(A[0],1,a,b,c,d)
print(M)
print(m)