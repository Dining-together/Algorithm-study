'''
시도2. - 사전이용해서 각 전화번호별로 확인
n*9 만큼 걸림 사전에서 find는 O(1)이므로.
'''
import sys
input=sys.stdin.readline
t=int(input())

def get_result(numbers,dict):
    for number in numbers:
        for length in range(1,len(number)-1):
            if(dict.get(number[:length])==1):
                return "NO"
    return "YES"

for k in range(t):
    n,ans=int(input()),"True"
    numbers=[input() for _ in range(n)]
    dict={number.strip(): 1 for number in numbers}
    print(get_result(numbers,dict))