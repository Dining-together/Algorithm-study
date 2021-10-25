n,m=map(int,input().split())
ricecakes=sorted(list(map(int,input().split())))

ans=-1
def binary_search(target,array,start,end):
    while(start<=end):
        mid=(start+end)//2
        total=0
        for i in range(n):
            if(array[i]-mid>0):
                total+=array[i]-mid
        if(total>=target):
            global ans
            ans=max(ans,mid)
            start=mid+1
        elif(total<target):
            end=mid-1
    return None

binary_search(m,ricecakes,ricecakes[0],ricecakes[n-1])

print(ans)
        
