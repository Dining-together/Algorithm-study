n,k=map(int,input().split())
a=sorted(list(map(int,input().split())))
b=sorted(map(int,input().split()),reverse=True)

for i in range(n):
    if(a[i]<b[i] and k>0):
        a[i]=b[i]
        k-=1

print(sum(a))
