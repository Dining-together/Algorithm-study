import sys
input = sys.stdin.readline

n = int(input())
n_list = list(map(int, input().split()))
m = int(input())
m_list = list(map(int, input().split()))


def binary_search(array, target, start, end):
    while start<=end:
        mid = (start+end)//2
        if (target == array[mid]):
            return "yes"
        elif (target < array[mid]):
            end = mid-1
        else:
            start = mid+1
    return "no"
    
        
for i in range(m):
    print(binary_search(sorted(n_list), m_list[i], 0, n-1), end=' ')



