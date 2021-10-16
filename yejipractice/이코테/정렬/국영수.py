import sys
input = sys.stdin.readline

n = int(input())
array = []

for _ in range(n):
    array.append(list(map(str, input().split())))

array.sort(key=lambda x: (-int(x[1]),
           int(x[2]), -int(x[3]), x[0]))  # sort key 사용법

for a in array:
    print(a[0])
