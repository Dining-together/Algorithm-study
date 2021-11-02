# 10815

import sys
input = sys.stdin.readline

n = int(input())
nlist = sorted(list(map(int, input().split())))
m = int(input())
mlist = list(map(int, input().split()))

def check(array, target, start, end):
    if start > end:
        return 0
    mid = (start+end)//2

    if array[mid] == target:
        return 1
    elif array[mid] > target:
        return check(array, target, start, mid-1)
    else:
        return check(array, target, mid+1, end)

for i in mlist:
    print(check(nlist, i, 0, n-1), end=' ')

    

