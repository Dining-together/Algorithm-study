import sys
input = sys.stdin.readline

n = int(input())
array = []

for _ in range(n):
    array.append(list(map(str, input().split())))

array.sort(key=lambda x: int(x[1]))

for a in array:
    print(a[0], end=" ")
