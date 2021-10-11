
n = int(input())
k = int(input())
map = [[0] * (n+1) for _ in range(n+1)]
direct = []

# 사과 위치 받기
for i in range(k):
    a, b = map(int, input().split())
    map[a][b] = 1

# 방향 전환
l = int(input())
for i in range(l):
    c, d = input().split()
    direct.append(int(c), d)

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

def turn(d, c):
    if c == 'L':
        d = (d-1)%4
    else:
        d = (d+1)%4
    return d

def simulate():
    x, y = 1,1
    map[x][y] = 2 # 뱀 존재 2
    d, time, index = 0,0,0
    q = [(x,y)] # 뱀이 차지하고 있는 위치
    
    while True:
        nx = x+dx[d]
        ny = y+dy[d]

        if 1<=nx and nx<=n and 1<=ny and ny<=n and map[nx][ny] !=2:

            # 사과 없는 경우 이동하고 꼬리 제거
            if map[nx][ny] == 0:
                map[nx][ny] = 2
                q.append((nx,ny))
                px, py = q.pop(0)
                map[px][py] = 0

            # 사과 있는 경우 이동하고 꼬리 그대로
            if map[nx][ny] == 1:
                map[nx][ny] =2
                q.append((nx,ny))

        # 벽이나 뱀의 몸통과 부딪히면 멈추기
        else:
            time+=1
            break
        x,y = nx, ny
        time+=1
        
        # 회전할 시간인 경우 회전
        if index < l and time == direct[index][0]:
            d = turn(d, direct[index][1])
            index += 1

    return time

print(simulate())

    
