import sys
input=sys.stdin.readline
n,info,total=int(input()),[],0

for _ in range(n):
    x=list(map(int,input().split()))
    info.append(x)
    total+=x[1]

#입력이 위치순이 아닐 수도 있으므로 정렬해야함!
info.sort()
limit,s=total//2+total%2,0

for i,p in info:
   s+=p
   if(s>=limit):
       print(i)
       break