# 백준 1744번
import sys
input = sys.stdin.readline

n = int(input())
minus = []
plus = []
ones = []
hasZero = 0
for _ in range(n):
    i = int(input())
    if i < 0:
        minus.append(i)
    elif i > 1:
        plus.append(i)
    elif i == 1:
        ones.append(i)
    elif i == 0:
        hasZero = 1

minus.sort()
plus.sort(reverse=True)

answer = []
for i in range(0, len(minus), 2):
    try:
        answer.append(minus[i]*minus[i+1])
    except:
        if hasZero == 0:
            answer.append(minus[i])

for i in range(0, len(plus), 2):
    try:
        answer.append(plus[i]*plus[i+1])
    except:
        answer.append(plus[i])

print(sum(answer)+sum(ones))

# 1은 곱하는 것보다 더하기
# 음수가 하나 남고 0이 있을 경우는 둘을 곱하기
