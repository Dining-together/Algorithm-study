import sys
input = sys.stdin.readline

inputs = list(map(int, input().rstrip('\n')))

n = len(inputs) // 2

right = sum(inputs[:n])
left = sum(inputs[n:])

if right == left:
    print("LUCKY")
else:
    print("READY")
