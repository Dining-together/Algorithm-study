n = int(input())
p = []

for _ in range(n):
    a, b = input().split()
    p.append([int(a), b])

p.sort(key= lambda x: int(x[0]))
 
for i in p:
    print(i[0], i[1])