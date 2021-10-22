from collections import deque
import sys
input = sys.stdin.readline

n, l, r = map(int, input().split())
board = []
for _ in range(n):
    board.append(list(map(int, input().split())))

isMove = False


def check_dfs(x, y, visited):
    global isMove
    visitedList = [(x, y)]
    queue = deque()
    queue.append((x, y))
    visited[x][y] = True
    summery = board[x][y]
    count = 1
    while queue:
        i, j = queue.popleft()
        cases = [[i+1, j], [i, j+1], [i-1, j], [i, j-1]]
        for case in cases:
            dx, dy = case
            if dx >= 0 and dy >= 0 and dx < n and dy < n and visited[dx][dy] == False:
                dif = abs(board[dx][dy] - board[i][j])
                if dif <= r and dif >= l:
                    queue.append((dx, dy))
                    visited[dx][dy] = True
                    summery += board[dx][dy]
                    count += 1
                    visitedList.append((dx, dy))
    if count > 1:
        isMove = True
        for i, j in visitedList:
            board[i][j] = summery // count

# 한 반복문에 연합 각 칸의 인구수까지 모두 구하도록 구현해서, 그 부분에서 시간 절약된 듯


total_count = 0

while 1:
    visited = [[False]*n for _ in range(n)]
    isMove = False
    for i in range(n):
        for j in range(n):
            if not visited[i][j]:
                check_dfs(i, j, visited)

    if isMove == False:
        break
    total_count += 1

print(total_count)
