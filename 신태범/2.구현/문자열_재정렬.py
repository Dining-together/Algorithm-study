s=sorted(input())
string,num="",0

for i in range(len(s)):
    if(s[i]<='9'):
        num+=int(s[i])
    else:
        string+=s[i]

print(string+str(num))