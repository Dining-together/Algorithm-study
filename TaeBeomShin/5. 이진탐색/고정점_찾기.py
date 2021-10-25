n=int(input())
numbers=list(map(int,input().split()))

def binary_search(array,start,end):
    while start<=end:
        mid=(start+end)//2
        if(mid==array[mid]):
            return mid
        elif(mid<array[mid]):
            end=mid-1
        elif(mid>array[mid]):
            start=mid+1
    return -1

ans=binary_search(numbers,0,n)
print(ans)