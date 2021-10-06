import sys
input = sys.stdin.readline

inputs = list(input().rstrip('\n'))
len_num = len(inputs)

for i in range(1, len(inputs)//2+1):
    ans = ''
    temp = inputs[0:i]
    count = 1
    for j in range(i, len(inputs), i):
        if temp == inputs[j:j+i]:
            count += 1
        else:
            ans += str(count) + "".join(temp) if count >= 2 else "".join(temp)
            temp = inputs[j:j+i]
            count = 1

    ans += str(count) + "".join(temp) if count >= 2 else "".join(temp)
    len_num = min(len_num, len(ans))

print(len_num)

# 로직 아이디어는 같지만 구현은 더 간단
