s = input()
num = 0
string = []

s = sorted(s)

for i in s:
    if(i.isalpha()):
        string.append(i)
    else:
        num+=int(i)

print(''.join(string)+str(num))
