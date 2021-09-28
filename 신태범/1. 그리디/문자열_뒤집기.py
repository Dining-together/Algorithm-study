'''
해결전략:0과 1의 묶음수중 더 작은 묶음의 개수
'''

s=input()
one,zero=0,0

before=s[0]
for i in range(1,len(s)):
    if(before!=s[i]):
        if(before=='0'):
            zero+=1
        else:
            one+=1
        before=s[i]

if(s[len(s)-1]=='0'):
    zero+=1
else:
    one+=1

print(min(one,zero))
