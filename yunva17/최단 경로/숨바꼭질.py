import heapq
import sys
from types import DynamicClassAttribute
input = sys.stdin.readline
INF = int(1e9)

n,m = map(int, input().split())
start = 1
graph = [[] for _ in range(n+1)]
distance = [INF]*(n+1)

for _ in range(m):
    a,b = map(int, input().split())
    graph[a].append((b,1))
    graph[b].append((a,1))
    
def dijkstra(start):
    q = []
    heapq.heappush(q,(0, start))
    distance[start]=0
    while q:
        dist, now = heapq.heappop(q)
        if distance[now]<dist:
            continue
        for i in graph[now]:
            cost = dist+i[1]
            if cost<distance[i[0]]:
                distance[i[0]]=cost
                heapq.heappush(q,(cost,i[0]))
                
dijkstra(start)

max_dis, dis, num = 0,0,0
for i in range(1, n+1):
    if dis < distance[i]:
        max_dis=i
        dis=distance[i]
        num=1
    elif dis == distance[i]:
        num+=1
print(max_dis, dis, num)
    
    
