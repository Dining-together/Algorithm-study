import copy

n=int(input())
m=int(input())

friends=[[] for _ in range(n)]
for i in range(m):
    a,b=map(int,input().split())
    friends[a-1].append(b-1)
    friends[b-1].append(a-1)

friend=copy.deepcopy(friends[0])
total_set=set(friend)

for f in friend:
    for p in friends[f]:
        total_set.add(p)

ans=len(total_set)
if(ans>=2):
    ans-=1
print(ans)