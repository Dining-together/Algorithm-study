#1920

import sys
input = sys.stdin.readline

def search(array, target, start, end):
    if start > end:
        return 0
    mid = (start+end)//2

    if array[mid] == target:
        return 1
    elif array[mid] > target:
        return search(array, target, start, mid-1)
    else:
        return search(array, target, mid+1, end)

n = int(input())
nlist = sorted(list(map(int, input().split())))
m = int(input())
mlist = list(map(int, input().split()))

for i in mlist:
    print(search(nlist, i, 0, n-1))

