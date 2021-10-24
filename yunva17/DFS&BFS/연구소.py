n, m = map(int, input().split())

graph = []
map = [[0]*m for _ in range(n)]
for _ in range(n):
    graph.append(list(map(int, input().split())))

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

result = 0

def add(x, y):
    for i in range(4):
        nx = x+dx[i]
        ny = y+dy[i]

        if nx>=0 and nx<n and ny>=0 and ny<m:
            if map[nx][ny] ==0:
                map[nx][ny]=2
                add(nx, ny)

def plus():
    score = 0
    for i in range(n):
        for j in range(m):
            if map[i][j] ==0:
                score+=1
    return score


# 매번 크기 계산
def dfs(count):
    global result
    if count == 3:
        for i in range(n):
            for j in range(m):
                map[i][j] = graph[i][j]
            for i in range(n):
                for j in range(m):
                    if map[i][j] ==2:
                        add(i,j)

            result = max(result, plus())
            return
    for i in range(n):
        for j in range(m):
            if graph[i][j] ==0:
                graph[i][j] =1
                count+=1
                dfs(count)
                graph[i][j]=0
                count-=1

dfs(0)
print(result)