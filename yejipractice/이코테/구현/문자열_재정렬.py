inputs = list(input())

alpha = []
digit = []

for i in inputs:
    if i.isdigit():
        digit.append(int(i))
    else:
        alpha.append(i)

alpha.sort()
print("".join(alpha)+str(sum(digit)))
