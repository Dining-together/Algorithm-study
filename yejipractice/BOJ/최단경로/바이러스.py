import heapq
import sys
input = sys.stdin.readline

n = int(input())
m = int(input())

INF = int(1e9)

distance = [INF] * (n+1)
graph = [[] for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append((b, 1))
    graph[b].append((a, 1))

q = []
start = 1
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

count = 0
for i in range(2, n+1):
    if distance[i] != INF:
        count += 1


print(count)
