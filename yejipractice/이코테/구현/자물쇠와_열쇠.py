import copy
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
key = []

for _ in range(n):
    key.append(list(map(int, input().split())))
lock = []
for _ in range(m):
    lock.append(list(map(int, input().split())))

board = [[-2 for i in range(m+(n-1)*2)] for j in range(m+(n-1)*2)]

for i in range(m):
    for j in range(m):
        board[n-1+i][n-1+j] = lock[i][j]


def check_key(x, y):
    b = copy.deepcopy(board)
    for i in range(n):
        for j in range(n):
            b[x+i][y+j] += key[i][j]
    for i in range(m):
        if 0 in b[n-1+i][n-1:n-1+m] or 2 in b[n-1+i][n-1:n-1+m]:
            return False
    return True


def sim():
    for i in range(len(board)-(n-1)):
        for j in range(len(board)-(n-1)):
            start_x, start_y = i, j
            if check_key(start_x, start_y) == True:
                return True
    return False


def turn_key():
    temp = [[0 for i in range(n)]for j in range(n)]
    for i in range(n):
        for j in range(n):
            temp[j][n-i-1] = key[i][j]
    return temp


turn_time = 1
while 1:
    if turn_time == 4:
        print("false")
        break
    if sim() == True:
        print("true")
        break
    else:
        key = turn_key()
        turn_time += 1

# 처음에 푼 코드
# 솔루션과 로직은 같은데 테스트 케이스에서 걸림
