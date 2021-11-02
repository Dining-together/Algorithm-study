s = input()

zero = 0
one = 0

pre = s[0]

# 첫번째 원소
if(pre == '1'):
    zero += 1
else:
    one += 1


for i in range(1, len(s)):
    if(pre != s[i]):
        if(s[i] == '1'):
            zero += 1
        else:
            one += 1
        pre = s[i]

print(min(zero, one))
    

