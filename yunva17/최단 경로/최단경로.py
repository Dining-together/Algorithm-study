# 1753
import sys
import heapq
input = sys.stdin.readline

INF = int(1e9)
v,e = map(int, input().split())
start = int(input())
graph = [[] for i in range(v+1)]
distance = [INF]*(v+1)

for _ in range(e):
    u,v,w = map(int, input().split())
    graph[u].append((v,w))
    
def d(start):
    q=[]
    heapq.heappush(q,(0, start))
    distance[start]=0
    while q:
        dis, now = heapq.heappop(q)
        if distance[now]<dis:
            continue
        for i in graph[now]:
            cost=dis+i[i]
            if cost<distance[i[0]]:
                distance[i[0]]=cost
                heapq.heappush(q, (cost,i[0]))
d(start)

for i in range(1, v+1):
    if distance[i] != INF:
        print(distance[i])
    else:
        print("INF")
        
