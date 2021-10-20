import sys
from collections import deque

input=sys.stdin.readline
n,m,k,x=map(int,input().split())
adj=[[] for _ in range(n)]
dist=[ -1 for _ in range(n)]

for _ in range(m):
    s,n=map(int,input().split())
    adj[s-1].append(n-1)

q,ans=deque(),[]
q.append(x-1)
dist[x-1]=0

while q:
    cur=q.popleft()
    if(dist[cur]==k):
        ans.append(cur)
    for next in adj[cur]:
        if(dist[next]>=0):
            continue
        q.append(next)
        dist[next]=dist[cur]+1

ans.sort()
if len(ans)==0:
    print(-1)
else:
    [print(a+1) for a in ans]