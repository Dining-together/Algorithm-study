n,c=map(int,input().split())
houses=sorted([int(input()) for _ in range(n)])

answer=0
def binary_search(target,array,start,end):
    while start<=end:
        mid=(start+end)//2
        before,count=0,1
        for i in range(1,len(array)):
            if(array[i]-array[before]>=mid):
                before=i
                count+=1
        if(count>=target):
            global answer
            answer=mid
            start=mid+1
        else:
            end=mid-1            

binary_search(c,houses,1,houses[-1]-houses[0])

print(answer)