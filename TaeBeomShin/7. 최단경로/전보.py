import heapq
import sys

import sys
input =sys.stdin.readline
INF =int(1e9)

N,M,C=map(int,input().split())
graph=[[] for i in range(N+1)]
visited=[False]*(N+1)
distance=[INF]*(N+1)

for _ in range(M):
    a,b,c=map(int,input().split())
    graph[a].append((b,c))

def dijkstra(start):
    q=[]
    heapq.heappush(q,(0,start))
    distance[start]=0
    while q:
        dist,now=heapq.heappop(q)
        if distance[now]<dist:
            continue
        for i in graph[now]:
            cost=dist+i[1]
            if cost<distance[i[0]]:
                distance[i[0]]=cost
                heapq.heappush(q,(cost,i[0]))

dijkstra(C)

t,ans=0,0
for d in distance:
    if d!=INF:
        ans+=1
        t=max(t,d)

print(ans-1,t)
