#1012

import sys
sys.setrecursionlimit(100000) # 파이썬 재귀 최대깊이 지정

t = int(input())

def dfs(x,y):
    if x>=n or y>=m or x<0 or y<0:
        return False

    if graph[x][y] == 1:
        graph[x][y] = 0
        dfs(x-1, y)
        dfs(x+1, y)
        dfs(x, y-1)
        dfs(x, y+1)
        return True

    return False
    
for _ in range(t):
    m,n,k = map(int, input().split())
    graph = [[0]*m for _ in range(n)]

    for _ in range(k):
        a,b = map(int, input().split())
        graph[b][a] = 1 # 배추 심은 곳

    result = 0
    for i in range(n):
        for j in range(m):
            if dfs(i, j) == True:
                result+=1
    print(result)




