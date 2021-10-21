from collections import deque
import sys
input = sys.stdin.readline

n, l, r = map(int, input().split())
board = []
for _ in range(n):
    board.append(list(map(int, input().split())))


def check_dfs(visited, x, y):
    visit_list = []
    queue = deque([(x, y)])
    while queue:
        i, j = queue.popleft()
        visited[i][j] = True
        visit_list.append((i, j))
        cases = [[i+1, j], [i, j+1], [i-1, j], [i, j-1]]
        for case in cases:
            dx, dy = case
            if dx >= 0 and dy >= 0 and dx < n and dy < n:
                dif = abs(board[dx][dy] - board[i][j])
                if dif <= r and dif >= l:
                    if (dx, dy) not in visit_list:
                        queue.append((dx, dy))
    visit_list = list(set(visit_list))
    if len(visit_list) == 1:
        return False
    return visit_list


count = 0
while 1:
    visited = [[False for i in range(n)]for j in range(n)]
    connected = []
    for i in range(n):
        for j in range(n):
            if not visited[i][j]:
                res = check_dfs(visited, i, j)
                if res != False:
                    connected.append(res)
    if connected == []:
        break
    count += 1
    for c in connected:
        sum = 0
        for cx, cy in c:
            sum += board[cx][cy]
        score = sum // len(c)
        for cx, cy in c:
            board[cx][cy] = score

print(count)
