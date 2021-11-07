# 2579

n = int(input())
d = [0]*301
nlist = [0]*301

for i in range(n):
    nlist[i] = int(input())

d[0] = nlist[0]
d[1] = nlist[0]+nlist[1]
d[2] = max(nlist[0]+nlist[2], nlist[1]+nlist[2] )

for i in range(3, n+1):
    d[i] = max(d[i-2]+nlist[i], d[i-3]+nlist[i-1]+nlist[i] )

print(d[n-1])

