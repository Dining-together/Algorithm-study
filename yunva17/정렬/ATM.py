# 11399

n = int(input())
p = list(map(int, input().split()))
result = 0

p.sort()
for i in range(n):
    result += sum(p[:i+1])

print(result)