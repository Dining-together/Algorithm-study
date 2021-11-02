# 9237

n = int(input())
trees = list(map(int, input().split()))

trees.sort()

for i in range(n):
    trees[i] -= i
    
print(max(trees)+1+n)

