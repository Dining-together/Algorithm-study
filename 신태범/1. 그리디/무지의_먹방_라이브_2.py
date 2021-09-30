'''
내 풀이가 시간초과 나는 이유 -> 정렬여러번해서 정렬과정에서 시간 초과 나는듯?

n=200,000 200,000 * log(200000)~1000-> 200,000,000 2억초? 
'''

import heapq

def solution(food_times,k):
    if sum(food_times) <= k:
        return -1
    
    q=[]
    for i in range(len(food_times)):
        heapq.heappush(q,(food_times[i],i+1))

    sum_value,previous,length=0,0,len(food_times)

    while sum_value+((q[0][0] -previous)*length) <=k:
        now=heapq.heappop(q)[0]
        sum_value+=(now-previous)*length
        length-=1
        previous=now
    
    result=sorted(q,key=lambda x: x[1])
    return result[(k-sum_value)&length][1]