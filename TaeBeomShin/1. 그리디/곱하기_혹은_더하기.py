'''
해결전략 : 이전결과와 현재수가 모두 1초과이면 곱셈, 아니면 덧셈
'''
num=input()

before=int(num[0])

if(len(num)>1):
    for i in range(1,len(num)):
        if(before>1 and int(num[i])>1):
            before*=int(num[i])
        else:
            before+=int(num[i])

print(before)