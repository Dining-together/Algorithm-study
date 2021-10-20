'''
1. 수를 정렬한다.
2. 더한 결과가 더크면 묶지않는다.
3. 그렇지 않으면 묶는다.
4. 앞에서 부터 한 결과와 뒤에서 부터 한 결과중 더 큰 값을 반환한다.

-> 테케 6 -8 -7 -6 6 7 8 에 대해 틀림.
'''
import sys

input=sys.stdin.readline
n=int(input())
numbers=[]

for _ in range(n):
    number=int(input())
    numbers.append(number)

numbers.sort()

# print(numbers)
idx,result=0,0
while idx<=len(numbers)-1:
    if(idx+1>=len(numbers)):
        result+=numbers[idx]
        break
    before,next=numbers[idx],numbers[idx+1]
    if(before*next<before+next):
        result+=before
        idx+=1
    else:
        result+=before*next
        idx+=2
    print(before,next,idx,result)

bidx,bresult=len(numbers)-1,0

print()
while bidx>=0:
    if(bidx-1<0):
        bresult+=numbers[bidx]
        break
    before,next=numbers[bidx],numbers[bidx-1]
    if(before*next<before+next):
        bresult+=before
        bidx-=1
    else:
        bresult+=before*next
        bidx-=2
    print(before,next,bidx,bresult)

print(max(bresult,result))
