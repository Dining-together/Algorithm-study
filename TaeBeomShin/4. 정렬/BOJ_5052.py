'''
시도1. - 정렬해서 완탐.
'''
import sys
input=sys.stdin.readline
t=int(input())

def get_result(numbers):

    for i in range (n):
        length=len(str(numbers[i]))
        for j in range(i+1,n):
            if(str(numbers[i])==str(numbers[j])[:length]):
                return "NO" 
    return "YES"

for k in range(t):
    n=int(input())
    numbers=sorted([int(input()) for _ in range(n)])
    print(get_result(numbers))