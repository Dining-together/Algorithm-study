import sys

input=sys.stdin.readline
n,m=map(int,input().split())
times=sorted([int(input()) for _ in range(n)])

ans=0
def binary_search(target,arr,start,end):
    while(start<=end):
        mid=(start+end)//2
        cnt=0
        for t in arr:
            cnt+=mid//t
        if(cnt>=target):
            global ans
            ans=mid
            end=mid-1
        else:
            start=mid+1

binary_search(m,times,0,times[-1]*m)

print(ans)