from bisect import bisect_left, bisect_right
import sys
input = sys.stdin.readline

n, x = map(int, input().split())
array = list(map(int, input().split()))


def count_by_range(array, left_value, right_value):
    right_idx = bisect_right(array, right_value)
    left_idx = bisect_left(array, left_value)
    return right_idx - left_idx


count = count_by_range(array, x, x)

if count == 0:
    print(-1)
else:
    print(count)

# bisect 이진탐색 라이브러리 알아두기
