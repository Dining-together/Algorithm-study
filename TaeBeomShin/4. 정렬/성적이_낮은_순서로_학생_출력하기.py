n,d=int(input()),{}
for _ in range(n):
    s=input().split()
    d[int(s[1])]=s[0]

d=sorted(d.items())

for k,v in d:
    print(v,end=" ")
