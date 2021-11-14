import heapq
import sys

import sys
input =sys.stdin.readline
INF =int(1e9)

n,m=map(int,input().split())
graph=[[] for i in range(n+1)]
visited=[False]*(n+1)
distance=[INF]*(n+1)

for _ in range(m):
    a,b=map(int,input().split())
    graph[a].append((b,1))
    graph[b].append((a,1))

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

dijkstra(1)

max_dist,num,cnt=0,0,0
for i in range(1,n+1):
    if max_dist<distance[i]:
        num=i
        max_dist=distance[i]
        cnt=1
    elif max_dist==distance[i]:
        cnt+=1
print(num,max_dist,cnt)
