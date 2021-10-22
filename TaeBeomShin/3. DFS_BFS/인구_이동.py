from collections import deque

n,l,r = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

is_move = False


def bfs(cx, cy, visited, grpah):
    global is_move
    people = graph[cx][cy]
    count = 1
    queue = deque()
    queue.append((cx, cy))
    visited[cx][cy] = True
    temp = []
    temp.append((cx, cy))

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue

            if visited[nx][ny]:
                continue

            if l <= abs(grpah[x][y] - grpah[nx][ny]) <= r:
                visited[nx][ny] = True
                queue.append((nx, ny))
                people += graph[nx][ny]
                count += 1
                temp.append((nx, ny))

    move_people = people // count

    if count > 1:
        is_move = True
        for x, y in temp:
            graph[x][y] = move_people

answer = 0

while True:
    is_move = False
    visited = [[False] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if not visited[i][j]:
                bfs(i, j, visited, graph)

    if is_move:
        answer += 1
    else:
        break

print(answer)