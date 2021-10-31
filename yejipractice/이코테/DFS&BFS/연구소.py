from itertools import combinations
import copy
import sys
input = sys.stdin.readline
n, m = map(int, input().split())
board = []
for _ in range(n):
    board.append(list(map(int, input().split())))

pos_virus = []
for i in range(n):
    for j in range(m):
        if board[i][j] == 0:
            pos_virus.append([i, j])

block_cases = list(combinations(pos_virus, 3))
ans = -1


def dfs(b, x, y):
    pp = [[x+1, y], [x-1, y], [x, y+1], [x, y-1]]
    for px, py in pp:
        if px >= 0 and py >= 0 and px < n and py < m:
            if b[px][py] == 0:
                b[px][py] = 2
                dfs(b, px, py)


for bc in block_cases:
    b = copy.deepcopy(board)
    for x, y in bc:
        b[x][y] = 1
    for x in range(n):
        for y in range(m):
            if board[x][y] == 2:
                dfs(b, x, y)
    sum = 0
    for row in range(n):
        sum += b[row].count(0)
    ans = max(ans, sum)

print(ans)
