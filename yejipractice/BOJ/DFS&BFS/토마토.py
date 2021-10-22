from collections import deque
import sys
input = sys.stdin.readline

m, n = map(int, input().split())
board = []
queue = deque()
for i in range(n):
    line = list(map(int, input().split()))
    board.append(line)
    if 1 in line:
        for j in range(len(line)):
            if line[j] == 1:
                queue.append((i, j))

while queue:
    x, y = queue.popleft()
    cases = [(x+1, y), (x-1, y), (x, y+1), (x, y-1)]
    for dx, dy in cases:
        if 0 <= dx < n and 0 <= dy < m and board[dx][dy] == 0:
            board[dx][dy] = board[x][y]+1
            queue.append((dx, dy))

answer = -1
for line in board:
    if 0 in line:
        answer = 0
        break
    answer = max(answer, max(line))
print(answer-1)
