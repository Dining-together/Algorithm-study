

# 90도 회전
def turn(key):
    n = len(key)
    arr = [[0] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            arr[j][n-i-1] = arr[i][j]

    return arr

# 자물쇠 키 확인
def check(lock):
    l = len(lock)//3
    for i in range(l, l*2):
        for j in range(l, l*2):
            if lock[i][j] != 1:
                return False
    return True


def solution(key, lock):
    a = len(lock)
    b = len(key)

    big = [[0]*3*a for _ in range(3*a)]

    for i in range(a):
        for j in range(a):
            big[i+a][j+a] = lock[i][j]

    
    for _ in range(4):
        key = turn(key)
        for x in range(a*2):
            for y in range(a*2):
                for i in range(b):
                    for j in range(b):
                        big[x+i][y+j] += key[i][j]
                
                if check(big) == True:
                    return True
                
                for i in range(b):
                    for j in range(b):
                        big[x+i][y+j] -= key[i][j]
    
    return False



