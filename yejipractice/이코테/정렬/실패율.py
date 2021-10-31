import sys
input = sys.stdin.readline

N = int(input())
stages = list(map(int, input().split()))


def solution(N, stages):
    scores = [0 for _ in range(N+2)]
    for i in stages:
        scores[i] += 1
    answer = []
    for i in range(1, N+1):
        up = scores[i]
        down = sum(scores[i:])
        if up == 0 or down == 0:
            ud = 0
        else:
            ud = up/down
        answer.append([ud, i])
    answer.sort(reverse=True, key=lambda x: (x[0], -x[1]))
    result = []
    for i in answer:
        result.append(i[1])
    return result

# devided by zero exception 주의


print(solution(N, stages))
