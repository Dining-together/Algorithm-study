from collections import deque
import sys
input = sys.stdin.readline

nums = list(map(int, input().rstrip('\n')))
queue = deque(nums)

result = queue.popleft()

while queue:
    n = queue.popleft()
    if n <= 1 or result <= 1:  # 이전과 다르게 한 번에 체크 가능
        result += n
    else:
        result *= n

print(result)
