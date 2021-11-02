import sys
input = sys.stdin.readline

n, m = map(int, input().split())

x, y, d = map(int, input().split())

maps = []
for _ in range(n):
    maps.append(list(map(int, input().split())))

visited = [[0 for i in range(m)] for j in range(n)]
visited[x][y] = 1

# 파이썬 배열 인덱스와 x축 y축을 헷갈리지 말자
turns = [[-1, 0], [0, 1], [1, 0], [0, -1]]


def turn_left(d):
    if d == 0:
        return 3
    return d-1


turn_time = 0
count = 1
while 1:
    d = turn_left(d)
    dx = x + turns[d][0]
    dy = y + turns[d][1]
    turn_time += 1
    if dx < 0 or dy < 0 or dx >= n or dy >= m:
        pass
    elif visited[dx][dy] == 1 or maps[dx][dy] == 1:
        pass
    elif visited[dx][dy] == 0 and maps[dx][dy] == 0:
        visited[dx][dy] = 1
        x, y = dx, dy
        count += 1
        turn_time = 0

    if turn_time == 4:
        dx = x - turns[d][0]
        dy = y - turns[d][1]
        if maps[dx][dy] == 1:
            break
        else:
            x, y = dx, dy
            turn_time = 0

print(count)
