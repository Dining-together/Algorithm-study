from itertools import combinations
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
board = []
for _ in range(n):
    board.append(list(map(int, input().split())))

chickens = []
houses = []

for i in range(n):
    for j in range(n):
        if board[i][j] == 1:
            houses.append([i, j])
        elif board[i][j] == 2:
            chickens.append([i, j])

choose = list(combinations(chickens, m))

ans = 30000000
for ch in choose:  # <M 개의 치킨집> 조합
    ct = 0
    for h in houses:   # 집마다
        ht = 100
        for c in ch:  # 가까운 치킨 거리 찾기
            distance = abs(h[0]-c[0])+abs(h[1]-c[1])
            ht = min(ht, distance)
        ct += ht  # 각 조합마다 전체 치킨 거리 구한 후
    ans = min(ans, ct)  # 조합마다 비교

print(ans)
