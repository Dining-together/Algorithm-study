from collections import deque
import sys
input = sys.stdin.readline

inputs = list(input().rstrip('\n'))
temp = []
count = 1
len_num = len(inputs)
answer = 0
for i in range(1, len(inputs)//2+1):
    queue = deque(inputs)
    ans = ''
    for _ in range(i):
        temp.append(queue.popleft())
    while 1:
        t = []
        if len(queue) >= i:
            for _ in range(i):
                t.append(queue.popleft())
        if temp == t:
            count += 1
        else:
            if count == 1:
                ans += "".join(temp)
            else:
                ans += str(count)+"".join(temp)
            count = 1
            temp = t
        if len(queue) < i and t == []:
            break
    if queue:
        ans += "".join(queue)
    if len_num > len(ans):
        len_num = len(ans)

print(len_num)
