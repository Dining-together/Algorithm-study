import sys
input = sys.stdin.readline

nums = list(map(int, input().rstrip('\n')))

pre = nums[0]
one = 0
zero = 0
for n in nums:
    if n != pre:
        if pre == 1:
            one += 1
        else:
            zero += 1
    pre = n

if nums[-1] == 1:
    one += 1
else:
    zero += 1

print(min(one, zero))
