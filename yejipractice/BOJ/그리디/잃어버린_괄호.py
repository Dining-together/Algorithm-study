# 백준 1541번
import sys
input = sys.stdin.readline

inputs = list(input().rstrip('\n'))+["e"]

sum = 0
space = 0
num = ""
switch = 0  # -인 상태 1 아님 0
for i in inputs:
    if i.isdigit():
        num += str(i)
    else:
        if i == "-":
            if switch == 0:
                sum += int(num)
                switch = 1
            else:
                space += int(num)
                sum -= space
                space = 0
        elif i == "+":
            if switch == 1:
                space += int(num)
            else:
                sum += int(num)
        else:
            if switch == 1:
                space += int(num)
                sum -= space
            else:
                sum += int(num)
        num = ""

print(sum)
