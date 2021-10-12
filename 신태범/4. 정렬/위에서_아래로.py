n=int(input())
l=sorted([int(input()) for _ in range(n)],reverse=True)
for i in l:
    print(i,end=" ")