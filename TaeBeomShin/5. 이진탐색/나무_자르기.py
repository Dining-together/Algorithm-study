n,m=map(int,input().split())
trees=sorted(list(map(int,input().split())))

ans=0
def binary_search(target,arr,start,end):
    while(start<=end):
        mid=(start+end)//2
        total=0
        for t in arr:
            if(t>mid):
                total+=t-mid
        if(total>=target):
            global ans
            ans=mid
            start=mid+1
        else:
            end=mid-1

binary_search(m,trees,0,trees[-1])

print(ans)