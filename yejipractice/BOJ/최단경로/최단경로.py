import sys
import heapq
input = sys.stdin.readline

v, e = map(int, input().split())
start = int(input())
INF = int(1e9)
distance = [INF] * (v+1)
graph = [[]for _ in range(v+1)]
for _ in range(e):
    a, b, w = map(int, input().split())
    graph[a].append((b, w))

q = []
distance[start] = 0
heapq.heappush(q, (0, start))
while q:
    dist, now = heapq.heappop(q)
    if distance[now] < dist:
        continue
    for i in graph[now]:
        cost = dist + i[1]
        if cost < distance[i[0]]:
            distance[i[0]] = cost
            heapq.heappush(q, (cost, i[0]))

for i in range(1, v+1):
    if distance[i] != INF:
        print(distance[i])
    else:
        print("INF")
