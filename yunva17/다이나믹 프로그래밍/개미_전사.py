n = int(input())

nlist = list(map(int, input().split()))

d = [0]*100
d[0] = nlist[0]
d[1]=max(nlist[0], nlist[1])

for i in range(2, n):
    d[i] = max(d[i-1], d[i-2]+nlist[i])

print(d[n-1])