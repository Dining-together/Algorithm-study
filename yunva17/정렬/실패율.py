n = int(input())

stages = list(map(int, input().split()))
result = []

def solution():
    stages.sort()
    
    count = []
    for i in range(1,n+1):
        c = 0
        for stage in stages:
            if stage == i:
                c+=1
        count.append(c)

    
    for i in range(len(count)):
        m = len(stages)
        s = sum(count[:i])

        result.append([i+1,count[i]/(m-s)])

    result.sort(reverse=True, key=lambda x: x[1])

    return [r[0] for r in result]


print(solution())