'''
len(weak) <=15 len(dist)<=8 (시계방향 반시계 방향 모두 되므로 16임)
내 로직, 모든경우 탐색.
1. 이동 거리가 큰 친구부터 임의의 위치에 놓는다.(시계방향 or 반시계 방향)
2. 어디까지 커버가 되는지 확인한다.
3. 커버가 모두 되면 결과를 반환하고 아니면 친구를 한 명 더 추가한다.

-> 시간초과.
'''

import itertools

def visit_check(friends,weak,n):
    check,visited=True,[0 for _ in range(n)]
    for friend in friends:
        if(friend[0]>0):
            for pos in range(friend[0]+1):
                visited[(friend[1]+n+pos)%n]=1
        else:
            for pos in range(0,friend[0]-1,-1):
                visited[(friend[1]+n+pos)%n]=1
                
    for w in weak:
        if(visited[w]==0):
            return False
            
    return True

def solution(n, weak, dist):
    answer = -1
    dist=sorted(dist,reverse=True)
    
    for i in range(1,len(dist)+1):
        #1.그룹 결정
        group=dist[:i]
        #1-1.그룹의 원소 별 시계, 반시계 결정
        default_list=[a for a in range(len(group))]
        for j in range(len(dist)+1):
            minus_choices=list(itertools.combinations(default_list,j))
            for choices in minus_choices:
                g=group[:]
                for k in range(len(choices)):
                    g[choices[k]]*=-1 
                #print(g)
                #2.각 원소를 임의의 weak 위치에 놓는다.
                weak_index=[_ for _ in range(len(weak))]
                positions=list(itertools.permutations(weak_index,len(g)))
                
                for position in positions:
                    friends=[(g[_],weak[position[_]]) for _ in range(len(g))]
                    #3. 어디까지 커버가 되는지 확인한다.
                    
                    check=visit_check(friends,weak,n)
                    if(check):
                        return len(friends)
                    
                    #print(friends,check)
    return answer