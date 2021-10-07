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


def solution(key, lock):
    m = len(lock)
    n = len(key)

    def make_board(lock):
        board = [[-2 for i in range(m+(n-1)*2)] for j in range(m+(n-1)*2)]
        for i in range(m):
            for j in range(m):
                board[n-1+i][n-1+j] = lock[i][j]
        return board

    def check_key(board):
        for i in range(n-1, n+m-1):
            for j in range(n-1, n+m-1):
                if board[i][j] != 1:
                    return False
        return True

    def translate(board, key, start_x, start_y):
        for i in range(n):
            for j in range(n):
                board[start_x+i][start_y+j] += key[i][j]
        return board

    def turn_key(key):
        temp = [[0 for i in range(n)]for j in range(n)]
        for i in range(n):
            for j in range(n):
                temp[j][n-i-1] = key[i][j]
        return temp

    board = make_board(lock)
    key1 = turn_key(key)
    key2 = turn_key(key1)
    key3 = turn_key(key2)

    for k in [key, key1, key2, key3]:
        for start_x in range(n+m-1):
            for start_y in range(n+m-1):
                b = translate(copy.deepcopy(board), k, start_x, start_y)
                if check_key(b):
                    return True
    return False


print(solution(key, lock))

# 솔루션 참고하고 수정한 코드
# 이전 코드 실패 원인: 인덱스 실수 추측
# 파이썬 이중 배열의 깊은 복사: copy 모듈의 deepcopy()
# copy(), [:] << 이중 배열에서는 얕은 복사가 된다. 그냥 배열에는 깊은 복사로 적용
