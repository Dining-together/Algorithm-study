'''
사전자료형 -> O(1)
이진탐색 -> O(logN)
'''
N,x=map(int,input().split())
numbers=list(map(int,input().split()))

def binary_search_lower(target,array,start,end):
    ans,check=1e9,False
    while start<=end:
        mid=(start+end)//2
        if(target<=array[mid]):
            if(target==array[mid]):
                check=True
            ans=min(ans,mid)
            end=mid-1
        elif(target>array[mid]):
            start=mid+1
    if(check):
        return ans
    else:
        return -1

def binary_search_upper(target,array,start,end):
    ans,check=-1,False
    while start<=end:
        mid=(start+end)//2
        if(target<array[mid]):
            end=mid-1
        elif(target>=array[mid]):
            if(target==array[mid]):
                check=True
            ans=max(ans,mid)
            start=mid+1
    if(check):
        return ans
    else:
        return -1

s=binary_search_lower(x,numbers,0,N-1)
e=binary_search_upper(x,numbers,0,N-1)

if(s==-1):
    print(-1)
else:
    print(e-s+1)