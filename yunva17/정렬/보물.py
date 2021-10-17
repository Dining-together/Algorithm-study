# 1026

n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

result = 0

a.sort()
b.sort(reverse=True)

for i in range(n):
    result += a[i] * b[i]

print(result)

## 다른 방법

for i in range(n):
    result+=min(a)*max(b)
    a.remove(min(a))
    b.remove(max(b))
    
print(result)