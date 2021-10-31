from collections import deque
import sys
input = sys.stdin.readline

n = int(input())  # 보드 크기
board = [[0 for i in range(n)]for j in range(n)]
apple_n = int(input())
apples = []
for _ in range(apple_n):
    apples.append(list(map(int, input().split())))
for apple in apples:
    x = apple[0]-1
    y = apple[1]-1
    board[x][y] = 1
move_n = int(input())
m = []
for _ in range(move_n):
    m.append(list(map(str, input().split())))
moves = deque(m)

snake = deque([[0, 0]])
x, y = 0, 0
dx, dy = 0, 1
count = 0


def turn_right(dx, dy):
    ds = [[0, 1], [1, 0], [0, -1], [-1, 0]]
    idx = ds.index([dx, dy])
    if idx == 3:
        return ds[0]
    else:
        return ds[idx + 1]


def turn_left(dx, dy):
    ds = [[0, 1], [-1, 0], [0, -1], [1, 0]]
    idx = ds.index([dx, dy])
    if idx == 3:
        return ds[0]
    else:
        return ds[idx + 1]


while 1:
    xx = x+dx
    yy = y+dy
    count += 1
    if xx < 0 or yy < 0 or xx >= n or yy >= n:
        break
    if [xx, yy] in snake:
        break
    if board[xx][yy] == 1:
        snake.appendleft([xx, yy])
        board[xx][yy] = 0  # 사과 먹은 다음 처리 놓친 실수 -> 수정
    else:
        snake.appendleft([xx, yy])
        snake.pop()
    x, y = xx, yy
    if len(moves) != 0 and count == int(moves[0][0]):
        move = moves.popleft()
        if move[1] == "L":
            dx, dy = turn_left(dx, dy)
        else:
            dx, dy = turn_right(dx, dy)

print(count)
