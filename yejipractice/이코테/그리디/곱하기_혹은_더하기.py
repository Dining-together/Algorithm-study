from collections import deque
import sys
input = sys.stdin.readline

nums = list(map(int, input().rstrip('\n')))
queue = deque(nums)

result = queue.popleft()
if result == 0:
    result = queue.popleft()

while queue:
    n = queue.popleft()
    if n == 0 or n == 1:
        result += n
    else:
        result *= n

print(result)
