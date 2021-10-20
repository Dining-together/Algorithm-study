'''
1. 수를 정렬한다.

0이하의 수와 1이상의 수를 나누어 생각한다.

2. 더한 결과가 더크면 묶지않는다.
3. 그렇지 않으면 묶는다.
4. 앞에서 부터 한 결과와 뒤에서 부터 한 결과중 더 큰 값을 반환한다.
'''
import sys

def getResult(numbers):
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
        # print(before,next,idx,result)
    return result

input=sys.stdin.readline
n=int(input())
positive_nums,negative_nums,ans=[],[],0

for _ in range(n):
    number=int(input())
    if number>0:
        positive_nums.append(number)
    else:
        negative_nums.append(number)

positive_nums.sort(reverse=True)
negative_nums.sort()

ans+=getResult(positive_nums)
# print(ans)
ans+=getResult(negative_nums)
print(ans)