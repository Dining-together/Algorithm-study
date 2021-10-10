inputs = list(input())

alpha = []
digit = []

for i in inputs:
    if i.isdigit():
        digit.append(int(i))
    else:
        alpha.append(i)

alpha.sort()
value = sum(digit)

# 0일 경우는 생략 << 놓친 포인트

if value != 0:
    print("".join(alpha)+str(value))
else:
    print("".join(alpha))
