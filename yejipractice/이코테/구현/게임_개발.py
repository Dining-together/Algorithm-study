import sys
input = sys.stdin.readline

n, m = map(int, input().split())

a, b, d = map(int, input().split())

board = []
for _ in range(m):
    board.append(list(map(int, input().split())))

visited = [[0 for i in range(n)] for j in range(m)]
visited[a][b] = 1
ds = [[-1, 0], [0, 1], [1, 0], [0, -1]]


def check_direction(d):
    if d == 0:
        d = 3
    else:
        d -= 1
    return d


turn = 0
count = 1
while 1:
    d = check_direction(d)
    da, db = a+ds[d][0], b+ds[d][1]
    turn += 1
    if da < 0 or db < 0 or da >= n or db >= m:
        continue
    if board[da][db] != 1 and visited[da][db] != 1:
        a, b = da, db
        visited[a][b] = 1
        count += 1
        turn = 0

    if turn == 4:
        da = a - ds[d][0]
        db = b - ds[d][1]
        if board[da][db] == 1:
            break
        a, b = da, db
        turn = 0

print(count)
