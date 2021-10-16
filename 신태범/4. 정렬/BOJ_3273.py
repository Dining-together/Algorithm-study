import sys
input=sys.stdin.readline
n=int(input())
numbers=list(map(int,input().split()))
d={num:0 for num in numbers}
x=int(input())
ans=0

for number in numbers:
    if(x-number>0 and x-number!= number and d.get(x-number)!=None and d.get(x-number)!=1):
        d[number]=1
        d[x-number]=1
        ans+=1

print(ans)