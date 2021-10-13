import sys
input = sys.stdin.readline

n, k = map(int, input().split())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

a.sort()
b.sort(reverse=True)

for i in range(k):
    if a[i] < b[i]:  # b의 원소가 더 작을 경우에는 교체하지 않기 고려
        a[i], b[i] = b[i], a[i]
    else:
        break

print(sum(a))
