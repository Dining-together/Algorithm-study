import sys
input = sys.stdin.readline

inputs = []

n = int(input())

data = []
for _ in range(n):
    data.append(list(map(int, input().split())))

data.sort(key=lambda d: (d[1], d[0]))

count = 1
endTime = data[0][1]
for i in range(1, n):
    if data[i][0] > endTime:
        count += 1
        endTime = data[i][1]

print(count)

# 핵심 아이디어: 전체를 시작시간의 오름차순으로 정렬을 한 뒤, 정렬된 리스트를 다시 끝나는 시간으로 오름차순 정렬해주는 것
# 앞 원소의 end보다 start가 더 클 경우 count +=1
