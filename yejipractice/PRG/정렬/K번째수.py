import sys
input = sys.stdin.readline

array = [1, 5, 2, 6, 3, 7, 4]
commands = [[2, 5, 3], [4, 4, 1], [1, 7, 3]]


def solution(array, commands):
    result = []
    for i, j, k in commands:
        cop = sorted(array[i-1:j])
        result.append(cop[k-1])
    return result


print(solution(array, commands))
