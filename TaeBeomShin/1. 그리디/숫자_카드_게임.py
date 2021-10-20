n,m=map(int,input().split())

ans=-1
for i in range(n):
    n=sorted(list(map(int,input().split())))[0]
    if(n>ans): ans=n

print(ans)