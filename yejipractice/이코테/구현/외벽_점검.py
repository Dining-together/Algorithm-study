from itertools import count, permutations
import sys
input = sys.stdin.readline

n = int(input())
weak = list(map(int, input().split()))
dist = list(map(int, input().split()))


def solution(n, weak, dist):
    length = len(weak)
    for i in range(length):
        weak.append(weak[i]+n)
    answer = len(dist) + 1
    for start in range(length):
        for friends in list(permutations(dist, len(dist))):
            count = 1
            posistion = weak[start] + friends[count-1]
            for index in range(start, start + len(weak)):
                if posistion < weak[index]:
                    count += 1
                    if count > len(dist):
                        break
                    posistion = weak[index] + friends[count-1]
            answer = min(answer, count)

    if answer > len(dist):
        return -1
    return answer


print(solution(n, weak, dist))
