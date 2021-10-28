import sys
input = sys.stdin.readline

n = 6
times = [7, 10]


def solution(n, times):
    answer = 0
    left = 1
    right = n * max(times)

    while left <= right:
        mid = (left + right) // 2

        people = 0
        for time in times:
            people += mid // time
            if people >= n:
                break

        if people >= n:
            answer = mid
            right = mid - 1
        else:
            left = mid + 1

    return answer


print(solution(n, times))
