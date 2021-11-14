import heapq
import sys
input = sys.stdin.readline
INF = int(1e9)

n,m,c = map(int, input().split())
graph = [[] for i in range(n+1)]
distance = [INF]*(n+1)

for _ in range(m):
    x,y,z = map(int, input().split())
    graph[x].append((y,z))
    
def dijkstra(start):
    q = []
    heapq.heappush(q,(0,start))
    distance[start] = 0
    while q: 
        dist, now = heapq.heappop(q) # 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
        if distance[now] < dist:
            continue
        for i in graph[now]:
            cost = dist+i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))
                
dijkstra(c)

result, md = 0
for d in distance:
    if d!=INF:
        result+=1
        md = max(md,d)
        
print(result-1, md)


