from itertools import combinations

n,m=map(int,input().split())
chickens,houses=[],[]

for i in range(n):
    ma=list(map(int,input().split()))
    for j in range(n):
        if(ma[j]==1):
            houses.append([i,j])
        elif(ma[j]==2):
            chickens.append([i,j])

min_dist=1e9

candidate=list(combinations(chickens,m))
for choices in candidate:
    current_dist=0
    for hx,hy in houses:
        current_house_dist=1e9
        for cx,cy in choices:
            current_house_dist=min(abs(hx-cx)+abs(hy-cy),current_house_dist)
        current_dist+=current_house_dist
    min_dist=min(current_dist,min_dist)

print(min_dist)