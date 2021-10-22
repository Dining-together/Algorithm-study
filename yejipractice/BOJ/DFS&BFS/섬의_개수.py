import sys
input = sys.stdin.readline


def dfs(x, y, board, visited, w, h):
    cases = [(x-1, y-1), (x-1, y), (x-1, y+1), (x, y-1),
             (x, y+1), (x+1, y-1), (x+1, y), (x+1, y+1)]
    for dx, dy in cases:
        if 0 <= dx < h and 0 <= dy < w and board[dx][dy] == 1 and visited[dx][dy] == False:
            visited[dx][dy] = True
            dfs(dx, dy, board, visited, w, h)
    return


while 1:
    w, h = map(int, input().split())
    if w == 0 and h == 0:
        break
    board = []
    for _ in range(h):
        board.append(list(map(int, input().split())))
    visited = [[False for i in range(w)]for j in range(h)]
    count = 0
    for i in range(h):
        for j in range(w):
            if board[i][j] == 1 and visited[i][j] == False:
                visited[i][j] = True
                dfs(i, j, board, visited, w, h)
                count += 1
    print(count)
