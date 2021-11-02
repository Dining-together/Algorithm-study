import sys
input = sys.stdin.readline

n, m = map(int, input().split())
array = list(map(int, input().split()))


def binary_search(array, target, start, end):
    result = 0
    while start<=end:
        total = 0
        mid = (start+end)//2
        for i in range(len(array)):
            if array[i] > mid:
                total += array[i]-mid
        if total < target:
            end = mid-1
        else:
            result = mid
            start = mid+1

    return result

print(binary_search(array, m, 0, max(array)))


