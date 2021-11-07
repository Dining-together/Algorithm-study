n = int(input())

num = [0]*n # 못생긴 수를 담기 위한 테이블
num[0]=1

i2 = i3 = i5 = 0
next2, next3, next5 = 2,3,5

for l in range(1,n):
    num[l] = min(next2, next3, next5)
    if num[l]== next2:
        i2+=1
        next2 = num[i2]*2
    if num[l]== next3:
        i3+=1
        next3 = num[i3]*3
    if num[l]== next5:
        i5+=1
        next5 = num[i5]*5

print(num[n-1])
