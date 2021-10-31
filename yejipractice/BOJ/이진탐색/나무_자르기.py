import sys
input = sys.stdin.readline

n, m = map(int, input().split())
nums = list(map(int, input().split()))


def check_sum(array, mid):
    sum = 0
    for a in array:
        if a > mid:
            sum += a-mid
    return sum


start = 0
end = max(nums)
answer = -1
while start <= end:
    mid = (start+end)//2
    sum = check_sum(nums, mid)
    if sum == m:
        answer = mid
        break
    if sum < m:
        end = mid - 1
    else:
        answer = mid
        start = mid + 1

print(answer)
