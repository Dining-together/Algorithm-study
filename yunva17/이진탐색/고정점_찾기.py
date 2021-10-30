import sys
input = sys.stdin.readline

n = int(input())
array = list(map(int, input().split()))

def binary_search(array, start, end):

    while start <=end:
        mid = (start+end)//2

        if mid == array[mid]:
            return mid
        elif mid > array[mid]:
            start = mid+1
        else:
            end = mid-1

    if mid == None:
            return -1
    
result = binary_search(array, 0, n-1)

if  result == None:
    print(-1)
else:
    print(result)
