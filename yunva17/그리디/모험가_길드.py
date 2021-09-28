n = int(input())
group = list(map(int, input().split()))

group.sort()

count = 0
result = 0

for i in group:
    count+=1
    if(count>=i):
        result+=1
        count=0

print(result)


