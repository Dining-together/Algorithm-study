import sys
input = sys.stdin.readline

n, k = map(int, input().split())
board = []
for _ in range(n):
    board.append(list(map(int, input().split())))
s, x, y = map(int, input().split())


def bfs(vx, vy, vv):
    cases = [[vx+1, vy], [vx-1, vy], [vx, vy+1], [vx, vy-1]]
    for c in cases:
        cx, cy = c
        if cx >= 0 and cy >= 0 and cx < n and cy < n:
            if board[cx][cy] == 0:
                board[cx][cy] = vv


for time in range(s):
    viruses = []
    for i in range(n):
        for j in range(n):
            if board[i][j] != 0:
                viruses.append([i, j, board[i][j]])
    viruses.sort(key=lambda x: x[-1])
    for v in viruses:
        vx, vy, vv = v
        bfs(vx, vy, vv)

print(board[x-1][y-1])
