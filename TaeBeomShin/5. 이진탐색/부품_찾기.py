import sys
input=sys.stdin.readline
n=int(input())
N=sorted(list(map(int,input().split())))
m=int(input())
M=sorted(list(map(int,input().split())))


def binary_search(target,array,start,end):
    while(start<=end):
        mid=(start+end)//2
        if(target==array[mid]):
            return True
        elif(target<array[mid]):
            end=mid-1
        elif(target>array[mid]):
            start=mid+1
    return False

for part in M:
    if(binary_search(part,N,0,n-1)):
        print("yes",end=" ")
    else:
        print("no",end=" ")

