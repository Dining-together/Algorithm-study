n, m, k = map(int, input().split())
nums = list(map(int, input().split()))

nums.sort(reverse=True)

first = nums[0]
second = nums[1]

result = 0

while(m!=0):
    for i in range(k):
        result += first
        m -= 1

    result += second
    m -= 1

print(result)