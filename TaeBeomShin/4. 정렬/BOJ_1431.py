def get_sum(l):
    return sum([int(i) for i in l if i.isdigit()])
    
n=int(input())
for number in sorted([input() for _ in range(n)],key=lambda l:(len(l),get_sum(l),l)):print(number)
