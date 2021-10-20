n=int(input())
data=list(map(int,input().split()))
data.sort()

result,count=0,0

for fury in data:
    count+=1
    if(count>=fury):
        result+=1
        count=0

print(result) 