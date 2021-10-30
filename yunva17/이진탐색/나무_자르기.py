# 2805

import sys
input = sys.stdin.readline

n, m = map(int, input().split())
tree = list(map(int, input().split()))

def cut_tree(array, target, start, end):
    result = 0
    while start<=end:
        total = 0
        mid = (start+end)//2

        for i in range(n):
            if array[i] > mid:
                total += array[i] - mid
        
        if total < target:
            end = mid-1
        else:
            result = mid
            start = mid+1
    return result

print(cut_tree(tree, m, 0, max(tree)))
