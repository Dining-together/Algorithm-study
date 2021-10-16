import sys
input = sys.stdin.readline

all = int(input())

for _ in range(all):
    n = int(input())
    nums = []
    for iii in range(n):
        nums.append(input().rstrip("\n"))
    nums.sort()
    answer = "YES"
    for i in range(n-1):
        if str(nums[i+1]).startswith(str(nums[i])):
            answer = "NO"
            break
    print(answer)

# 완전 탐색을 했더니 시간 초과
# 12, 1234, 145 라는 입력이 들어왔을 때,
# 정수면 12, 145, 1234 순으로 정렬되지만,
# 문자열이면 12, 1234, 145 순으로 정렬된다.
# i 번째와 i+1 번째 문자만 비교하면 된다.
# str 에는 startWith, endWith 함수가 있다.
