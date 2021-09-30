'''
1. 완전탐색 O(N^2) : 이중루프
2. 그리디 O(N) + 정렬 O(NlogN): 정렬 후 조건에따라 계산  
'''
n,m=map(int,input().split())
balls=sorted(list(map(int,input().split())))

before,i,count,ans=balls[0],1,1,0
while(i<len(balls)):
    if(balls[i]==before):
        count+=1
    else:
        ans+=count*(len(balls)-i)
        before,count=balls[i],1
    i+=1

print(ans)