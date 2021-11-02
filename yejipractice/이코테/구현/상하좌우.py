import sys
input = sys.stdin.readline

n = int(input())
moves = list(map(str, input().split()))

x, y = 1, 1

for move in moves:
    if move == "R":
        dx = x
        dy = y + 1
    elif move == "L":
        dx = x
        dy = y - 1
    elif move == "U":
        dx = x - 1
        dy = dy
    elif move == "D":
        dx = x + 1
        dy = dy

    if dx > 0 and dy > 0 and dx <= n and dy <= n:
        x, y = dx, dy

print(x, y)
