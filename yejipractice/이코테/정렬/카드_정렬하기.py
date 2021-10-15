import heapq

n = int(input())

heap = []
for i in range(n):
    heapq.heappush(heap, int(input()))

result = 0

while len(heap) != 1:
    one = heapq.heappop(heap)
    two = heapq.heappop(heap)
    s = one + two
    result += s
    heapq.heappush(heap, s)

print(result)


# 항상 가장 작은 크기의 두 카드 묶음을 알기 위해서 우선 순위 큐, 힙 자료구조를 사용해서 구현
# 파이썬에서는 heapq 라이브러리를 제공
