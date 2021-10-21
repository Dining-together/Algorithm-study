from itertools import combinations
import sys
input = sys.stdin.readline

n = int(input())
board = []
for _ in range(n):
    board.append(list(map(str, input().split())))
teachers = []
spaces = []

for i in range(n):
    for j in range(n):
        if board[i][j] == "T":
            teachers.append([i, j])
        elif board[i][j] == "X":
            spaces.append([i, j])


def watch(x, y, direction):
    # 왼쪽
    if direction == 0:
        while y >= 0:
            if board[x][y] == 'S':  # 학생이 있는 경우
                return True
            if board[x][y] == 'O':  # 장애물이 있는 경우
                return False
            y -= 1
    # 오른쪽 방향으로 감시
    if direction == 1:
        while y < n:
            if board[x][y] == 'S':  # 학생이 있는 경우
                return True
            if board[x][y] == 'O':  # 장애물이 있는 경우
                return False
            y += 1
    # 위쪽 방향으로 감시
    if direction == 2:
        while x >= 0:
            if board[x][y] == 'S':  # 학생이 있는 경우
                return True
            if board[x][y] == 'O':  # 장애물이 있는 경우
                return False
            x -= 1
    # 아래쪽 방향으로 감시
    if direction == 3:
        while x < n:
            if board[x][y] == 'S':  # 학생이 있는 경우
                return True
            if board[x][y] == 'O':  # 장애물이 있는 경우
                return False
            x += 1
    return False


def process():
    for x, y in teachers:
        for i in range(4):
            if watch(x, y, i):
                return True
    return False


# 3개의 장애물 위치 고른다는 점에서 itertools 생각해내기 -> 브루트포스
# 반대 경우를 생각해낸 다음 반환 해버리는게 더 효율적
result = False
cases = list(combinations(spaces, 3))
for case in cases:
    for x, y in case:
        board[x][y] = "O"
    if not process():
        result = True
        break
    for x, y in case:
        board[x][y] = "X"

if result:
    print("YES")
else:
    print("NO")
