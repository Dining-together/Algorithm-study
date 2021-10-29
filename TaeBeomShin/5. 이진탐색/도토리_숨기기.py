import sys
input=sys.stdin.readline

n,k,d=map(int,input().split())
stricts=[list(map(int,input().split())) for _ in range(k)]

ans=0
def binary_search(target,array,start,end):
    while start<=end:
        mid=(start+end)//2
        global ans
        total=0
        for s,e,t in array:
            if(s<=mid):
                total+=(min(e,mid)-s)//t+1
        if(total>=target):
            end=mid-1
            ans=mid
        else:
            start=mid+1

binary_search(d,stricts,0,1e6)
print(int(ans))